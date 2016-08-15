package ua.skillsup.gelius.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.model.Data;
import ua.skillsup.gelius.model.Response;
import ua.skillsup.gelius.model.ResponseCode;
import ua.skillsup.gelius.model.ResponseWithList;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.model.dto.dictionary.*;
import ua.skillsup.gelius.service.ProductService;
import ua.skillsup.gelius.service.ValidationService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ValidationService<ProductDto> validationService;

    @Override
    public Response createProduct(ProductDto product) {
        if ( product.getNew() ) {
            int productNumber = this.productDao.getNewDatasheetCount() + 1;
            product.setProductNumber(productNumber);
        }

        //Парсинг (из строки) и заполнение дат:
        LocalDate productCreateDate = parseDate(product.getProductCreateDateValue());
        if (productCreateDate == null) {
            return new Response(ResponseCode.ERROR);
        }
        LocalDate productUpdateDate = parseDate(product.getProductUpdateDateValue());
        if (productUpdateDate == null) {
            return new Response(ResponseCode.ERROR);
        }
        product.setProductCreateDate(productCreateDate);
        product.setProductUpdateDate(productUpdateDate);

        //Дозаполнение полей ДТО:
        ProductDto filledProduct = fillProductDto(product);

        //Валидация ДТО (в т.ч. проверка обязательных полей):
        List<String> validationErrors = this.validationService.validation(filledProduct);
        if (validationErrors.size() != 0) {
            return new ResponseWithList<>(ResponseCode.VALIDATION_ERROR, validationErrors);
        }

        long productId = this.productDao.create(filledProduct);

        return new Response(ResponseCode.OK, productId);
    }
    
    private ProductDto fillProductDto(ProductDto product) {
        product.setClient( new ClientDto(product.getClientId()) );
        product.setProductType( new ProductTypeDto(product.getProductTypeId()) );
        product.setFormat( new FormatDto(product.getFormatId()) );
        product.setProfile( new ProfileDto(product.getProfileId()) );
        product.setCardboardBrand( new CardBoardBrandDto(product.getCardboardBrandId()) );
        product.setCelluloseLayer( new CelluloseLayerDto(product.getCelluloseLayerId()) );
        product.setFaceLayer( new FaceLayerDto(product.getFaceLayerId()) );
        product.setInnerLayer( new InnerLayerDto(product.getInnerLayerId()) );
        product.setConnectionValve( new ConnectionValveDto(product.getConnectionValveId()) );
        product.setPacking( new PackingDto(product.getPackingId()) );
        product.setPallet( new PalletDto(product.getPalletId()) );
        product.setPalletPlacement( new PalletPlacementDto(product.getPalletPlacementId()) );

        return product;
    }

    /*Парсинг даты.
    Если произошла ошибка парсинга, вернет null.
    */
    private LocalDate parseDate(String dateValue) {
        LocalDate date;
        try {
            date = LocalDate.parse(dateValue, Data.DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            return null;
        }
        return date;
    }


}
