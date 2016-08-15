package ua.skillsup.gelius.model.convert;

import ua.skillsup.gelius.model.convert.dictionary.*;
import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.entity.ProductRegister;

import java.util.ArrayList;
import java.util.List;

public final class ProductRegisterConvert {

    private ProductRegisterConvert() {
    }

    public static ProductRegister convert(ProductRegisterDto productDto) {
        if (productDto == null) {
            return null;
        }
        ProductRegister product = new ProductRegister();
        product.setId(productDto.getId());
        product.setClient(ClientConvert.convert(productDto.getClient()));
        product.setProductName(productDto.getProductName());
        product.setProductType(ProductTypeConvert.convert(productDto.getProductType()));
        product.setInnerLength(productDto.getInnerLength());
        product.setInnerHeight(productDto.getInnerHeight());
        product.setInnerWidth(productDto.getInnerWidth());
        product.setCardboardBrand(CardBoardBrandConvert.convert(productDto.getCardboardBrand()));
        product.setProfile(ProfileConvert.convert(productDto.getProfile()));
        product.setFaceLayer(FaceLayerConvert.convert(productDto.getFaceLayer()));
        product.setInnerLayer(InnerLayerConvert.convert(productDto.getInnerLayer()));
        product.setCliche(productDto.getCliche());
        return product;
    }

    public static ProductRegisterDto convert(ProductRegister product) {
        if (product == null) {
            return null;
        }
        ProductRegisterDto productDto = new ProductRegisterDto();
        productDto.setId(product.getId());
        productDto.setClient(ClientConvert.convert(product.getClient()));
        productDto.setProductName(product.getProductName());
        productDto.setProductType(ProductTypeConvert.convert(product.getProductType()));
        productDto.setInnerLength(product.getInnerLength());
        productDto.setInnerHeight(product.getInnerHeight());
        productDto.setInnerWidth(product.getInnerWidth());
        productDto.setCardboardBrand(CardBoardBrandConvert.convert(product.getCardboardBrand()));
        productDto.setProfile(ProfileConvert.convert(product.getProfile()));
        productDto.setFaceLayer(FaceLayerConvert.convert(product.getFaceLayer()));
        productDto.setInnerLayer(InnerLayerConvert.convert(product.getInnerLayer()));
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
