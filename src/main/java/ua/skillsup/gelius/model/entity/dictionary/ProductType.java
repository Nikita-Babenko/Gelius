package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity       //  Тип изделия
@Table(name = "product_type")
public class ProductType {

    @Id
    @Column(name = "product_type_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 50)
    @Column(name = "product_type")
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
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductType{");
        sb.append("id=").append(id);
        sb.append(", productsType='").append(productsType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}