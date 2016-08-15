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
        return product;
    }

    public static ProductRegisterDto convert(ProductRegister product) {
        if (product == null) {
            return null;
        }
        ProductRegisterDto productDto = new ProductRegisterDto();
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
