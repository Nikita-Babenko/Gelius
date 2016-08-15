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
        return product;
    }


    public static ProductDto convert(Product product) {
        if (product == null) {
            return null;
        }
        ProductDto productDto = new ProductDto();
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
