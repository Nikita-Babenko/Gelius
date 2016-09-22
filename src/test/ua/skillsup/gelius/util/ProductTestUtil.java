package ua.skillsup.gelius.util;

import ua.skillsup.gelius.dao.entity.Product;
import ua.skillsup.gelius.dao.entity.dictionary.CardboardBrand;
import ua.skillsup.gelius.dao.entity.dictionary.Client;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.model.dto.dictionary.*;

import java.time.LocalDate;
import java.util.ArrayList;

public final class ProductTestUtil {

    private ProductTestUtil() {
    }

    public static Product createProduct(int productNumber, boolean isNew, String productName, long client,
                                        int blankFormat, int innerWidth, int innerHeight, int innerLength,
                                        long cardBoardBrand) {
        Product product = new Product();
        product.setProductNumber(productNumber);
        product.setNew(isNew);
        product.setProductName(productName);

        Client productClient = new Client();
        productClient.setId(client);

        product.setClient(productClient);
        product.setBlankFormat(blankFormat);
        product.setInnerWidth(innerWidth);
        product.setInnerHeight(innerHeight);
        product.setInnerLength(innerLength);

        CardboardBrand productCardboardBrand = new CardboardBrand();
        productCardboardBrand.setId(cardBoardBrand);

        product.setCardboardBrand(productCardboardBrand);

        product.setBigovki(new ArrayList<>());
        product.setPerforations(new ArrayList<>());
        product.setProducibilityNotes(new ArrayList<>());

        return product;
    }

    public static ProductDto getProductDtoWithSpecificStaticValues(boolean isNew){
        ProductDto productDto = new ProductDto();
        productDto.setProductNumber(11111);
        productDto.setProductCreateDate(LocalDate.now());
        productDto.setProductUpdateDate(LocalDate.now());
        productDto.setPersonPrepared("Holtvianskyi");
        productDto.setUse(false);
        productDto.setClient(new ClientDto(1L));
        productDto.setProductName("Product Name");
        productDto.setProductType(new ProductTypeDto(1L));
        productDto.setInnerLength(100);
        productDto.setInnerHeight(100);
        productDto.setInnerWidth(100);
        productDto.setTheoreticalSquare(9.4);
        productDto.setActualSquare(4.5);
        productDto.setFormat(new FormatDto(1L));
        productDto.setProfile(new ProfileDto(1L));
        productDto.setCardboardBrand(new CardboardBrandDto(1L));
        productDto.setCelluloseLayer(new CelluloseLayerDto(1L));
        productDto.setFaceLayer(new FaceLayerDto(1L));
        productDto.setInnerLayer(new InnerLayerDto(1L));
        productDto.setSpecialConditions("Conditions");
        productDto.setMaterial("Material");
        productDto.setSizeWorkpieceLength(344);
        productDto.setSizeWorkpieceWidth(223);
        productDto.setNumberFromSheet(2);
        productDto.setBlankFormat(223);
        productDto.setNew(isNew);
        productDto.setConnectionValve(new ConnectionValveDto(1L));
        productDto.setStamp("Stamp");
        productDto.setCliche("Cliche");
        productDto.setPacking(new PackingDto(1L));
        productDto.setNumberInPack(4);
        productDto.setNumberInTransportPackage(6);
        productDto.setPackageHeight(200);
        productDto.setPackageWidth(100);
        productDto.setPackageLength(300);
        productDto.setPallet(new PalletDto(1L));
        productDto.setPalletPlacement(new PalletPlacementDto(1L));
        productDto.setPalletRows(2);
        productDto.setNumberLoadCar(4);
        productDto.setProductionFormat(2);
        productDto.setNumberBlanksOnFormat(2);

        productDto.setBigovki(new ArrayList<>());
        productDto.setProducibilityNotes(new ArrayList<>());
        productDto.setPerforations(new ArrayList<>());

        return productDto;
    }
}
