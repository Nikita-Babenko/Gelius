package ua.skillsup.gelius.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Objects;

public class BigovkiDto {

    private Long id;

    @JsonBackReference
    private ProductDto product;

    private Integer value;

    public BigovkiDto() {
    }

    public BigovkiDto(Long id) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BigovkiDto that = (BigovkiDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BigovkiDto{");
        sb.append("id=").append(id);
        sb.append(", product=").append(product.getId());
        sb.append(", value='").append(value).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
