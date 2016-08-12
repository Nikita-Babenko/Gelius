package ua.skillsup.gelius.model.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity       //  Тип изделия
@Table(name = "PRODUCT_TYPE")
public class ProductType {

    @Id
    @Column(name = "PRODUCT_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 50)
    @Column(name = "PRODUCT_TYPE")
    private String productsType;

    public ProductType(String productsType) {
        this.productsType = productsType;
    }

    public ProductType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductsType() {
        return productsType;
    }

    public void setProductsType(String productsType) {
        this.productsType = productsType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductType)) return false;
        ProductType that = (ProductType) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getProductsType(), that.getProductsType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProductsType());
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", productsType='" + productsType + '\'' +
                '}';
    }
}