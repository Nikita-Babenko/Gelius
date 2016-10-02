package ua.skillsup.gelius.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.validation.constraints.Min;
import java.util.Objects;

public class BigovkiDto {

    private Long id;

    @JsonBackReference
    private ProductDto product;

    @Min(value = 1, message = "величина биговки не может быть меньше {value}")
    private Double value;

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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BigovkiDto that = (BigovkiDto) o;
        return Objects.equals(product, that.product) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, value);
    }

    @Override
    public String toString() {
        return "BigovkiDto{" + "id=" + id +
                ", product=" + product.getId() +
                ", value='" + value + '\'' +
                '}';
    }
}
