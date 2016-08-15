package ua.skillsup.gelius.model.dto;

public class PerforationDto {

    private Long id;

    private ProductDto product;

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

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
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
