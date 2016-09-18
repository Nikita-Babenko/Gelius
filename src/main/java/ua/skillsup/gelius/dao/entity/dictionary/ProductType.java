package ua.skillsup.gelius.dao.entity.dictionary;

import javax.persistence.*;
import java.util.Objects;

@Entity       //  Тип изделия
@Table(name = "product_type")
public class ProductType {

    @Id
    @Column(name = "product_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_type")
    private String productType;

    public ProductType() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductType that = (ProductType) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductType{");
        sb.append("id=").append(id);
        sb.append(", productType='").append(productType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}