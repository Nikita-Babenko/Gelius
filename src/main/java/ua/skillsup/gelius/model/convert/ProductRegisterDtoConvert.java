package ua.skillsup.gelius.model.convert;

import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.entity.ProductRegister;

import java.util.ArrayList;
import java.util.List;

public final class ProductRegisterDtoConvert {

    private ProductRegisterDtoConvert() {
    }

    public static ProductRegister convert(ProductRegisterDto productDto) {
        if (productDto == null) {
            return null;
        }
        ProductRegister product = new ProductRegister();
        product.setId(productDto.getId());
        product.setClient(productDto.getClient());
        product.setProductName(productDto.getProductName());
        product.setProductType(productDto.getProductType());
        product.setInnerLength(productDto.getInnerLength());
        product.setInnerHeight(productDto.getInnerHeight());
        product.setInnerWidth(productDto.getInnerWidth());
        product.setCardboardBrand(productDto.getCardboardBrand());
        product.setProfile(productDto.getProfile());
        product.setFaceLayer(productDto.getFaceLayer());
        product.setInnerLayer(productDto.getInnerLayer());
        product.setCliche(productDto.getCliche());
        return product;
    }

    public static ProductRegisterDto convert(ProductRegister product) {
        if (product == null) {
            return null;
        }
        ProductRegisterDto productDto = new ProductRegisterDto();
        productDto.setId(product.getId());
        productDto.setClient(product.getClient());
        productDto.setProductName(product.getProductName());
        productDto.setProductType(product.getProductType());
        productDto.setInnerLength(product.getInnerLength());
        productDto.setInnerHeight(product.getInnerHeight());
        productDto.setInnerWidth(product.getInnerWidth());
        productDto.setCardboardBrand(product.getCardboardBrand());
        productDto.setProfile(product.getProfile());
        productDto.setFaceLayer(product.getFaceLayer());
        productDto.setInnerLayer(product.getInnerLayer());
        productDto.setCliche(product.getCliche());
        return productDto;
    }

    public static List<ProductRegisterDto> convertList(List<ProductRegister> list){
        if(list == null){
            return null;
        }
        List<ProductRegisterDto> listDto = new ArrayList<>();
        list.forEach(productRegister -> listDto.add(convert(productRegister)));
        return listDto;
    }


}
