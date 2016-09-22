package ua.skillsup.gelius.model.dto;

import java.util.Objects;

public class PrintDto {

    private Long id;

    private ProductDto product;

    private String color;

    private String name;

    private Integer squareSeal;

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

    public Integer getSquareSeal() {
        return squareSeal;
    }

    public void setSquareSeal(Integer squareSeal) {
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
