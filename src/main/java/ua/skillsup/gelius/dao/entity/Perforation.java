package ua.skillsup.gelius.dao.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "perforation")
public class Perforation {

    @Id
    @Column(name = "perforation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name = "value")
    private Integer value;

    public Perforation() {
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
        Perforation that = (Perforation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Perforation{");
        sb.append("id=").append(id);
        sb.append(", product=").append(product.getId());
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
