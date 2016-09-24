package ua.skillsup.gelius.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ua.skillsup.gelius.annotation.CheckDoubleAboveZero;

import javax.validation.constraints.Size;
import java.util.Objects;

public class PrintDto {

    private Long id;

    @JsonBackReference
    private ProductDto product;

    @Size(max = 6, message = "код цвета не должен превышать {max} символов")
    private String color;

    @Size(max = 50, message = "название цвета не должно превышать {max} символов")
    private String name;

    @CheckDoubleAboveZero(message = "площадь запечатки должна быть больше нуля")
    private Double squareSeal;

    public PrintDto() {
    }

    public PrintDto(Long id) {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSquareSeal() {
        return squareSeal;
    }

    public void setSquareSeal(Double squareSeal) {
        this.squareSeal = squareSeal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrintDto printDto = (PrintDto) o;
        return Objects.equals(product, printDto.product) &&
                Objects.equals(color, printDto.color) &&
                Objects.equals(name, printDto.name) &&
                Objects.equals(squareSeal, printDto.squareSeal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, color, name, squareSeal);
    }

    @Override
    public String toString() {
        return "PrintDto{" + "id=" + id +
                ", product=" + product.getId() +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", squareSeal=" + squareSeal +
                '}';
    }
}
