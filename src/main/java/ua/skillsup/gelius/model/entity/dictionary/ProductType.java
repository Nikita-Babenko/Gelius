package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;

@Entity       //  Тип изделия
@Table(name = "product_type")
public class ProductType {

    @Id
    @Column(name = "product_type_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public String getProductsType() {
        return productType;
    }

    public void setProductsType(String productsType) {
        this.productType = productsType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductType{");
        sb.append("id=").append(id);
        sb.append(", productsType='").append(productType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}