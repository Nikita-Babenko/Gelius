package ua.skillsup.gelius.converters;

import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.dao.entities.Product;

public final class EntityDtoConverter {

    private EntityDtoConverter() {

    }
    public static Product convert(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productDto.getId());
        product.setClient(productDto.getClient());
        product.setProductsName(productDto.getProductsName());
        product.setProductsType(productDto.getProductsType());
        product.setInnerLength(productDto.getInnerLength());
        product.setInnerWidth(productDto.getInnerWidth());
        product.setInnerHeight(productDto.getInnerHeight());
        product.setInnerHeight(productDto.getInnerHeight());
        product.setCardboardBrand(productDto.getCardboardBrand());
        product.setProfile(productDto.getProfile());
        product.setColour(productDto.getColour());
        product.setPrint(productDto.getPrint());
        product.setActivity(productDto.getActivity());
        return product;
    }
    public static ProductDto convert(Product product) {
        if (product == null) {
            return null;
        }
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setClient(product.getClient());
        productDto.setProductsName(product.getProductsName());
        productDto.setProductsType(product.getProductsType());
        productDto.setInnerLength(product.getInnerLength());
        productDto.setInnerWidth(product.getInnerWidth());
        productDto.setInnerHeight(product.getInnerHeight());
        productDto.setInnerHeight(product.getInnerHeight());
        productDto.setCardboardBrand(product.getCardboardBrand());
        productDto.setProfile(product.getProfile());
        productDto.setColour(product.getColour());
        productDto.setPrint(product.getPrint());
        productDto.setActivity(product.getActivity());
        return productDto;
    }

}
