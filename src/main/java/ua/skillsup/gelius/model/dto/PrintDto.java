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
        return Objects.equals(id, printDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PrintDto{");
        sb.append("id=").append(id);
        sb.append(", product=").append(product.getId());
        sb.append(", color='").append(color).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", squareSeal=").append(squareSeal);
        sb.append('}');
        return sb.toString();
    }
}
