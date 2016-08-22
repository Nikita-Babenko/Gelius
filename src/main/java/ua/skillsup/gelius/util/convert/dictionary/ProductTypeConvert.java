package ua.skillsup.gelius.util.convert.dictionary;

import ua.skillsup.gelius.dao.entity.dictionary.ProductType;
import ua.skillsup.gelius.model.dto.dictionary.ProductTypeDto;

public final class ProductTypeConvert {

    private ProductTypeConvert() {
    }

    public static ProductType convert(ProductTypeDto productTypeDto) {
        if (productTypeDto == null) {
            return null;
        }
        ProductType productType = new ProductType();
        productType.setId(productTypeDto.getId());
        productType.setProductType(productTypeDto.getProductType());

        return productType;
    }

    public static ProductTypeDto convert(ProductType productType) {
        if (productType == null) {
            return null;
        }
        ProductTypeDto productTypeDto = new ProductTypeDto();
        productTypeDto.setId(productType.getId());
        productTypeDto.setProductType(productType.getProductType());

        return productTypeDto;
    }
}