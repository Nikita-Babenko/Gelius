package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;

public class ProductTypeDto {

    private Long id;

    @Size(max = 50)
    private String productType;

    public ProductTypeDto() {
    }

    public ProductTypeDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductTypeDto{");
        sb.append("id=").append(id);
        sb.append(", productType='").append(productType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}