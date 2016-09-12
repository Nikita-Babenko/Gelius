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
    public String save(ProductDto product) {
        if ( product.getIsNew() ) {
            int productNumber = getProductNumber();
            product.setProductNumber(productNumber);
        }

        //Filling other DTO fields (vocabularies):
        ProductDto filledProduct = isFillProduct(product);

        //DTO validation (including mandatory fields check):
        List<String> validationErrors = this.validationService.validation(filledProduct);
        if ( !validationErrors.isEmpty() ) {
            throw new ProductValidationException(validationErrors);
        }

        //Check existing product with same productNumber in DB (AFTER DTO validation, because before validation productNumber may be null):
        if (!filledProduct.getIsNew()) {
            isProductExist( filledProduct.getProductNumber() );
        }

        if (filledProduct.getIsUse() == null) {
            filledProduct.setIsUse(false);
        }

        this.productDao.save(filledProduct);

        return getFullProductNumber(filledProduct.getProductNumber(), filledProduct.getIsNew());
    }

    @Override
    public String delete(long productId) {
        ProductDto productDto = productDao.delete(productId);
        return getFullProductNumber(productDto.getProductNumber(), productDto.getIsNew());
    }

    @Override
    public int getProductNumber() {
        return this.productDao.getMaxNumberOfNewProduct() + 1;
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
    public ProductDto findById(long productId) {
        return this.productDao.findById(productId);
    }

    @Override
    public void update(ProductDto product) {

        //Filling DTO fields if it has zero values
        ProductDto updatedProduct = isFillProduct(product);

        //DTO validation (including mandatory fields check)
        List<String> validationErrors = this.validationService.validation(updatedProduct);
        if ( !validationErrors.isEmpty() ) {
            throw new ProductValidationException(validationErrors);
        }

        //Check existing product with same productNumber in DB
        if (!updatedProduct.getIsNew()) {
            isProductExist(updatedProduct.getProductNumber() );
        }

        if (updatedProduct.getIsUse() == null) {
            updatedProduct.setIsUse(false);
        }

        productDao.update(product);
    }

    private ProductDto isFillProduct(ProductDto product) {
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

    private void isProductExist(int productNumber) {
        boolean isExists = this.productDao.isOldProductExist(productNumber);
        if (isExists) {
            throw new ProductExistsException(productNumber);
        }
    }
}
