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
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InnerLayer{");
        sb.append("id=").append(id);
        sb.append(", innerLayer='").append(innerLayer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}