package ua.skillsup.gelius.dao.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bigovki")
public class Bigovki {

    @Id
    @Column(name = "bigovki_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name = "value")
    private Integer value;

    public Bigovki() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
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
        Bigovki bigovki = (Bigovki) o;
        return Objects.equals(product, bigovki.product) &&
                Objects.equals(value, bigovki.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, value);
    }

    @Override
    public String toString() {
        return "Bigovki{" + "id=" + id +
                ", product=" + product.getId() +
                ", value='" + value + '\'' +
                '}';
    }
}
