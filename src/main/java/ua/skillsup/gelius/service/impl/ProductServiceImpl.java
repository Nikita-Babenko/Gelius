package ua.skillsup.gelius.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.exception.ProductExistsException;
import ua.skillsup.gelius.exception.ProductValidationException;
import ua.skillsup.gelius.model.Data;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.service.ProductService;
import ua.skillsup.gelius.service.ValidationService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ValidationService<ProductDto> validationService;

    @Override
    public String createProduct(ProductDto product) {
        if ( product.getIsNew() ) {
            int productNumber = getProductNumberOfNewDatasheet();
            product.setProductNumber(productNumber);
        }

        //Filling other DTO fields (vocabularies):
        ProductDto filledProduct = fillProductDto(product);

        //DTO validation (including mandatory fields check):
        List<String> validationErrors = this.validationService.validation(filledProduct);
        if ( !validationErrors.isEmpty() ) {
            throw new ProductValidationException(validationErrors);
        }

        //Check existing product with same productNumber in DB (AFTER DTO validation, because before validation productNumber may be null):
        if (!filledProduct.getIsNew()) {
            checkExistenceOldProductWithSameProductNumber( filledProduct.getProductNumber() );
        }

        if (filledProduct.getIsUse() == null) {
            filledProduct.setIsUse(false);
        }

        this.productDao.create(filledProduct);

        return getFullProductNumber(filledProduct.getProductNumber(), filledProduct.getIsNew());
    }
    
    private ProductDto fillProductDto(ProductDto product) {
        if ( product.getClient().getId() == 0 ) {
            product.setClient(null);
        }
        if ( product.getProductType().getId() == 0 ) {
            product.setProductType(null);
        }
        if ( product.getFormat().getId() == 0 ) {
            product.setFormat(null);
        }
        if ( product.getProfile().getId() == 0 ) {
            product.setProfile(null);
        }
        if ( product.getCardboardBrand().getId() == 0 ) {
            product.setCardboardBrand(null);
        }
        if ( product.getCelluloseLayer().getId() == 0 ) {
            product.setCelluloseLayer(null);
        }
        if ( product.getFaceLayer().getId() == 0 ) {
            product.setFaceLayer(null);
        }
        if ( product.getInnerLayer().getId() == 0 ) {
            product.setInnerLayer(null);
        }
        if ( product.getConnectionValve().getId() == 0 ) {
            product.setConnectionValve(null);
        }
        if ( product.getPacking().getId() == 0 ) {
            product.setPacking(null);
        }
        if ( product.getPallet().getId() == 0 ) {
            product.setPallet(null);
        }
        if ( product.getPalletPlacement().getId() == 0 ) {
            product.setPalletPlacement(null);
        }

        return product;
    }

    //If product with same productNumber exists in DB, throw ProductExistsException
    private void checkExistenceOldProductWithSameProductNumber(int productNumber) {
        boolean isExists = this.productDao.isExistsOldProductWithSameProductNumber(productNumber);
        if (isExists) {
            throw new ProductExistsException(productNumber);
        }
    }

    @Override
    public int getProductNumberOfNewDatasheet() {
        return this.productDao.getMaxProductNumberOfNewDatasheets() + 1;
    }

    @Override
    public String getFullProductNumber(int productNumber, boolean isNewDatasheet) {
        int needLength = isNewDatasheet ? Data.ProductNumber.DIGITS_COUNT_NEW : Data.ProductNumber.DIGITS_COUNT_OLD;
        int currentLength = String.valueOf(productNumber).length();
        int delta = needLength - currentLength;
        StringBuilder value = new StringBuilder(productNumber);
        for (int i = 0; i < delta; i++) {
            value.append(Data.ProductNumber.PLACEHOLDER);
        }
        value.append(productNumber);
        return value.toString();
    }

    @Override
    //Can returns null if product not found.
    public ProductDto findById(long productId) {
        return this.productDao.findById(productId);
    }
}
