package ua.skillsup.gelius.dao.entity.dictionary;

import javax.persistence.*;
import java.util.Objects;

@Entity       //  Внутренний слой
@Table(name = "inner_layer")
public class InnerLayer {

    @Id
    @Column(name = "inner_layer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inner_layer")
    private String innerLayer;

    public InnerLayer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInnerLayer() {
        return innerLayer;
    }

    public void setInnerLayer(String innerLayer) {
        this.innerLayer = innerLayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnerLayer that = (InnerLayer) o;
        return Objects.equals(innerLayer, that.innerLayer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(innerLayer);
    }

    @Override
    public String toString() {
        return "InnerLayer{" + "id=" + id +
                ", innerLayer='" + innerLayer + '\'' +
                '}';
    }
}