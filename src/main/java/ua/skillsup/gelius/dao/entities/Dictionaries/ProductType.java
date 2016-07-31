package ua.skillsup.gelius.dao.entities.Dictionaries;

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
    private String typeOfProduct;

    public ProductType(Long id, String typeOfProduct) {
        this.id = id;
        this.typeOfProduct = typeOfProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductType)) return false;
        ProductType that = (ProductType) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getTypeOfProduct(), that.getTypeOfProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTypeOfProduct());
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", typeOfProduct='" + typeOfProduct + '\'' +
                '}';
    }
}