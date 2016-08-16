package ua.skillsup.gelius.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.exception.ProductValidationException;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.model.dto.dictionary.CardBoardBrandDto;
import ua.skillsup.gelius.model.dto.dictionary.CelluloseLayerDto;
import ua.skillsup.gelius.model.dto.dictionary.ClientDto;
import ua.skillsup.gelius.model.dto.dictionary.ConnectionValveDto;
import ua.skillsup.gelius.model.dto.dictionary.FaceLayerDto;
import ua.skillsup.gelius.model.dto.dictionary.FormatDto;
import ua.skillsup.gelius.model.dto.dictionary.InnerLayerDto;
import ua.skillsup.gelius.model.dto.dictionary.PackingDto;
import ua.skillsup.gelius.model.dto.dictionary.PalletDto;
import ua.skillsup.gelius.model.dto.dictionary.PalletPlacementDto;
import ua.skillsup.gelius.model.dto.dictionary.ProductTypeDto;
import ua.skillsup.gelius.model.dto.dictionary.ProfileDto;
import ua.skillsup.gelius.service.ProductService;
import ua.skillsup.gelius.service.ValidationService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ValidationService<ProductDto> validationService;

    @Override
    public long createProduct(ProductDto product) {
        if ( product.getNew() ) {
            int productNumber = this.productDao.getMaxProductNumberOfNewDatasheets() + 1;
            product.setProductNumber(productNumber);
        }

        //Date parsing, filling them to DTO:
        LocalDate productCreateDate = this.validationService.parseDate( product.getProductCreateDateValue() );
        LocalDate productUpdateDate = this.validationService.parseDate( product.getProductUpdateDateValue() );
        product.setProductCreateDate(productCreateDate);
        product.setProductUpdateDate(productUpdateDate);

        //TODO replace all empty strings for null-s

        //Filling other DTO fields (LocalDates and vocabularies):
        ProductDto filledProduct = fillProductDto(product);

        //DTO validation (including mandatory fields check):
        List<String> validationErrors = this.validationService.validation(filledProduct);
        if ( !validationErrors.isEmpty() ) {
            throw new ProductValidationException(validationErrors);
        }

        return this.productDao.create(filledProduct);
    }
    
    private ProductDto fillProductDto(ProductDto product) {
        if ( product.getClientId() != null ) {
            product.setClient( new ClientDto(product.getClientId()) );
        }
        if ( product.getProductTypeId() != null ) {
            product.setProductType( new ProductTypeDto(product.getProductTypeId()) );
        }
        if ( product.getFormatId() != null ) {
            product.setFormat(new FormatDto(product.getFormatId()));
        }
        if ( product.getProfileId() != null ) {
            product.setProfile( new ProfileDto(product.getProfileId()) );
        }
        if ( product.getCardboardBrandId() != null ) {
            product.setCardboardBrand( new CardBoardBrandDto(product.getCardboardBrandId()) );
        }
        if ( product.getCelluloseLayerId() != null ) {
            product.setCelluloseLayer( new CelluloseLayerDto(product.getCelluloseLayerId()) );
        }
        if ( product.getFaceLayerId() != null ) {
            product.setFaceLayer( new FaceLayerDto(product.getFaceLayerId()) );
        }
        if ( product.getInnerLayerId() != null ) {
            product.setInnerLayer( new InnerLayerDto(product.getInnerLayerId()) );
        }
        if ( product.getConnectionValveId() != null ) {
            product.setConnectionValve( new ConnectionValveDto(product.getConnectionValveId()) );
        }
        if ( product.getPackingId() != null ) {
            product.setPacking( new PackingDto(product.getPackingId()) );
        }
        if ( product.getPalletId() != null ) {
            product.setPallet( new PalletDto(product.getPalletId()) );
        }
        if ( product.getPalletPlacementId() != null ) {
            product.setPalletPlacement( new PalletPlacementDto(product.getPalletPlacementId()) );
        }

        return product;
    }

    @Override
    //Can returns null if product not found.
    public ProductDto findById(long productId) {
        return this.productDao.findById(productId);
    }
}
