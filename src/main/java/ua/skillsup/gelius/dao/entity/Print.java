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

    @Column(name = "square_seal", precision = 5, scale = 3)
    private Double squareSeal;

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

    public Double getSquareSeal() {
        return squareSeal;
    }

    public void setSquareSeal(Double squareSeal) {
        this.squareSeal = squareSeal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Print print = (Print) o;
        return Objects.equals(product, print.product) &&
                Objects.equals(color, print.color) &&
                Objects.equals(name, print.name) &&
                Objects.equals(squareSeal, print.squareSeal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, color, name, squareSeal);
    }

    @Override
    public String toString() {
        return "Print{" + "id=" + id +
                ", product=" + product +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", squareSeal=" + squareSeal +
                '}';
    }
}
