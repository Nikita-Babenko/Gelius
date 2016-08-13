package ua.skillsup.gelius.model.convert;

import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.model.entity.Product;

import java.util.ArrayList;
import java.util.List;

public final class ProductDtoConvert {

    private ProductDtoConvert() {
    }

    public static Product convert(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productDto.getId());
        product.setProductNumber(productDto.getProductNumber());
        product.setNew(productDto.getNew());
        product.setProductCreateDate(productDto.getProductCreateDate());
        product.setProductUpdateDate(productDto.getProductUpdateDate());
        product.setPersonPrepared(productDto.getPersonPrepared());
        product.setUse(productDto.getUse());
        product.setClient(productDto.getClient());
        product.setProductName(productDto.getProductName());
        product.setProductType(productDto.getProductType());
        product.setInnerLength(productDto.getInnerLength());
        product.setInnerWidth(productDto.getInnerWidth());
        product.setInnerHeight(productDto.getInnerHeight());
        product.setTheoreticalSquare(productDto.getTheoreticalSquare());
        product.setActualSquare(productDto.getActualSquare());
        product.setFormat(productDto.getFormat());
        product.setProfile(productDto.getProfile());
        product.setCardboardBrand(productDto.getCardboardBrand());
        product.setCelluloseLayer(productDto.getCelluloseLayer());
        product.setFaceLayer(productDto.getFaceLayer());
        product.setInnerLayer(productDto.getInnerLayer());
        product.setMaterial(productDto.getMaterial());
        product.setSizeWorkpieceLength(productDto.getSizeWorkpieceLength());
        product.setSizeWorkpieceWidth(productDto.getSizeWorkpieceWidth());
        product.setNumberFromSheet(productDto.getNumberFromSheet());
        product.setBlankFormat(productDto.getBlankFormat());
        product.setConnectionValve(productDto.getConnectionValve());
        product.setStamp(productDto.getStamp());
        product.setCliche(productDto.getCliche());
        product.setPacking(productDto.getPacking());
        product.setNumberInPack(productDto.getNumberInPack());
        product.setNumberInTransportPackage(productDto.getNumberInTransportPackage());
        product.setPackageLength(productDto.getPackageLength());
        product.setPackageWidth(productDto.getPackageWidth());
        product.setPackageHeight(productDto.getPackageHeight());
        product.setPallet(productDto.getPallet());
        product.setPalletPlacement(productDto.getPalletPlacement());
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
        productDto.setNew(product.getNew());
        productDto.setProductCreateDate(product.getProductCreateDate());
        productDto.setProductUpdateDate(product.getProductUpdateDate());
        productDto.setPersonPrepared(product.getPersonPrepared());
        productDto.setUse(product.getUse());
        productDto.setClient(product.getClient());
        productDto.setProductName(product.getProductName());
        productDto.setProductType(product.getProductType());
        productDto.setInnerLength(product.getInnerLength());
        productDto.setInnerWidth(product.getInnerWidth());
        productDto.setInnerHeight(product.getInnerHeight());
        productDto.setTheoreticalSquare(product.getTheoreticalSquare());
        productDto.setActualSquare(product.getActualSquare());
        productDto.setFormat(product.getFormat());
        productDto.setProfile(product.getProfile());
        productDto.setCardboardBrand(product.getCardboardBrand());
        productDto.setCelluloseLayer(product.getCelluloseLayer());
        productDto.setFaceLayer(product.getFaceLayer());
        productDto.setInnerLayer(product.getInnerLayer());
        productDto.setMaterial(product.getMaterial());
        productDto.setSizeWorkpieceLength(product.getSizeWorkpieceLength());
        productDto.setSizeWorkpieceWidth(product.getSizeWorkpieceWidth());
        productDto.setNumberFromSheet(product.getNumberFromSheet());
        productDto.setBlankFormat(product.getBlankFormat());
        productDto.setConnectionValve(product.getConnectionValve());
        productDto.setStamp(product.getStamp());
        productDto.setCliche(product.getCliche());
        productDto.setPacking(product.getPacking());
        productDto.setNumberInPack(product.getNumberInPack());
        productDto.setNumberInTransportPackage(product.getNumberInTransportPackage());
        productDto.setPackageLength(product.getPackageLength());
        productDto.setPackageWidth(product.getPackageWidth());
        productDto.setPackageHeight(product.getPackageHeight());
        productDto.setPallet(product.getPallet());
        productDto.setPalletPlacement(product.getPalletPlacement());
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
