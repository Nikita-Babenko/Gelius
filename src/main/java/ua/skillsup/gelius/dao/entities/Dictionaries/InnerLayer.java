package ua.skillsup.gelius.dao.entities.Dictionaries;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity       //  Внутренний слой
@Table(name = "INNER_LAYER")
public class InnerLayer {

    @Id
    @Column(name = "INNER_LAYER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 50)
    @Column(name = "INNER_LAYER")
    private String innerLayer;

    public InnerLayer(String innerLayer) {
        this.innerLayer = innerLayer;
    }

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
        if (!(o instanceof InnerLayer)) return false;
        InnerLayer that = (InnerLayer) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getInnerLayer(), that.getInnerLayer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getInnerLayer());
    }

    @Override
    public String toString() {
        return "InnerLayer{" +
                "id=" + id +
                ", innerLayer='" + innerLayer + '\'' +
                '}';
    }
}