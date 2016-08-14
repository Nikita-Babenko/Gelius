package ua.skillsup.gelius.model.dto;

import ua.skillsup.gelius.model.entity.Product;

public class PerforationDto {

    private Long id;

    private Product product;

    private Integer value;

    public PerforationDto() {
    }

    public PerforationDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PerforationDto{");
        sb.append("id=").append(id);
        sb.append(", product=").append(product);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
