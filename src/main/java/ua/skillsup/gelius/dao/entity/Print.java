package ua.skillsup.gelius.dao.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "print")
public class Print {

    @Id
    @Column(name = "print_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name = "colour")
    private String color;

    @Column(name = "name")
    private String name;

    @Column(name = "square_seal")
    private Integer squareSeal;

    public Print() {
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
        Print print = (Print) o;
        return Objects.equals(id, print.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Print{");
        sb.append("id=").append(id);
        sb.append(", product=").append(product);
        sb.append(", color='").append(color).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", squareSeal=").append(squareSeal);
        sb.append('}');
        return sb.toString();
    }
}
