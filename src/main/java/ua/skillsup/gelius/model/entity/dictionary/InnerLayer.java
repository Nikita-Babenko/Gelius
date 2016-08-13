package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;

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
    public String toString() {
        return "InnerLayer{" +
                "id=" + id +
                ", innerLayer='" + innerLayer + '\'' +
                '}';
    }
}