package ua.skillsup.gelius.util.convert;

import ua.skillsup.gelius.dao.entity.Product;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.util.convert.dictionary.*;

import java.util.ArrayList;
import java.util.List;

public final class ProductConvert {

    private ProductConvert() {
    }

    public static Product convert(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productDto.getId());
        product.setProductNumber(productDto.getProductNumber());
        product.setNew(productDto.getIsNew());
        product.setProductCreateDate(productDto.getProductCreateDate());
        product.setProductUpdateDate(productDto.getProductUpdateDate());
        product.setPersonPrepared(productDto.getPersonPrepared());
        product.setUse(productDto.getIsUse());
        product.setClient(ClientConvert.convert(productDto.getClient()));
        product.setProductName(productDto.getProductName());
        product.setProductType(ProductTypeConvert.convert(productDto.getProductType()));
        product.setInnerLength(productDto.getInnerLength());
        product.setInnerWidth(productDto.getInnerWidth());
        product.setInnerHeight(productDto.getInnerHeight());
        product.setTheoreticalSquare(productDto.getTheoreticalSquare());
        product.setActualSquare(productDto.getActualSquare());
        product.setFormat(FormatConvert.convert(productDto.getFormat()));
        product.setProfile(ProfileConvert.convert(productDto.getProfile()));
        product.setCardboardBrand(CardboardBrandConvert.convert(productDto.getCardboardBrand()));
        product.setCelluloseLayer(CelluloseLayerConvert.convert(productDto.getCelluloseLayer()));
        product.setFaceLayer(FaceLayerConvert.convert(productDto.getFaceLayer()));
        product.setInnerLayer(InnerLayerConvert.convert(productDto.getInnerLayer()));
        product.setMaterial(productDto.getMaterial());
        product.setSizeWorkpieceLength(productDto.getSizeWorkpieceLength());
        product.setSizeWorkpieceWidth(productDto.getSizeWorkpieceWidth());
        product.setNumberFromSheet(productDto.getNumberFromSheet());
        product.setBlankFormat(productDto.getBlankFormat());
        product.setConnectionValve(ConnectionValveConvert.convert(productDto.getConnectionValve()));
        product.setStamp(productDto.getStamp());
        product.setCliche(productDto.getCliche());
        product.setPacking(PackingConvert.convert(productDto.getPacking()));
        product.setNumberInPack(productDto.getNumberInPack());
        product.setNumberInTransportPackage(productDto.getNumberInTransportPackage());
        product.setPackageLength(productDto.getPackageLength());
        product.setPackageWidth(productDto.getPackageWidth());
        product.setPackageHeight(productDto.getPackageHeight());
        product.setPallet(PalletConvert.convert(productDto.getPallet()));
        product.setPalletPlacement(PalletPlacementConvert.convert(productDto.getPalletPlacement()));
        product.setPalletRows(productDto.getPalletRows());
        product.setNumberLoadCar(productDto.getNumberLoadCar());
        product.setProductionFormat(productDto.getProductionFormat());

        return product;
    }


    public static ProductDto convert(Product product) {
        if (product == null) {
            return null;
        }
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setProductNumber(product.getProductNumber());
        productDto.setIsNew(product.getNew());
        productDto.setProductCreateDate(product.getProductCreateDate());
        productDto.setProductUpdateDate(product.getProductUpdateDate());
        productDto.setPersonPrepared(product.getPersonPrepared());
        productDto.setIsUse(product.getUse());
        productDto.setClient(ClientConvert.convert(product.getClient()));
        productDto.setProductName(product.getProductName());
        productDto.setProductType(ProductTypeConvert.convert(product.getProductType()));
        productDto.setInnerLength(product.getInnerLength());
        productDto.setInnerWidth(product.getInnerWidth());
        productDto.setInnerHeight(product.getInnerHeight());
        productDto.setTheoreticalSquare(product.getTheoreticalSquare());
        productDto.setActualSquare(product.getActualSquare());
        productDto.setFormat(FormatConvert.convert(product.getFormat()));
        productDto.setProfile(ProfileConvert.convert(product.getProfile()));
        productDto.setCardboardBrand(CardboardBrandConvert.convert(product.getCardboardBrand()));
        productDto.setCelluloseLayer(CelluloseLayerConvert.convert(product.getCelluloseLayer()));
        productDto.setFaceLayer(FaceLayerConvert.convert(product.getFaceLayer()));
        productDto.setInnerLayer(InnerLayerConvert.convert(product.getInnerLayer()));
        productDto.setMaterial(product.getMaterial());
        productDto.setSizeWorkpieceLength(product.getSizeWorkpieceLength());
        productDto.setSizeWorkpieceWidth(product.getSizeWorkpieceWidth());
        productDto.setNumberFromSheet(product.getNumberFromSheet());
        productDto.setBlankFormat(product.getBlankFormat());
        productDto.setConnectionValve(ConnectionValveConvert.convert(product.getConnectionValve()));
        productDto.setStamp(product.getStamp());
        productDto.setCliche(product.getCliche());
        productDto.setPacking(PackingConvert.convert(product.getPacking()));
        productDto.setNumberInPack(product.getNumberInPack());
        productDto.setNumberInTransportPackage(product.getNumberInTransportPackage());
        productDto.setPackageLength(product.getPackageLength());
        productDto.setPackageWidth(product.getPackageWidth());
        productDto.setPackageHeight(product.getPackageHeight());
        productDto.setPallet(PalletConvert.convert(product.getPallet()));
        productDto.setPalletPlacement(PalletPlacementConvert.convert(product.getPalletPlacement()));
        productDto.setPalletRows(product.getPalletRows());
        productDto.setNumberLoadCar(product.getNumberLoadCar());
        productDto.setProductionFormat(product.getProductionFormat());

        return productDto;
    }


    public static List<ProductDto> convertList(List<Product> list){
        if(list == null){
            return null;
        }
        List<ProductDto> listDto = new ArrayList<>();
        list.forEach(product -> listDto.add(convert(product)));
        return listDto;
    }

}
