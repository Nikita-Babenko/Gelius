package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity       //  Внутренний слой
@Table(name = "inner_layer")
public class InnerLayer {

    @Id
    @Column(name = "inner_layer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 50)
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
    public String toString() {
        final StringBuilder sb = new StringBuilder("InnerLayer{");
        sb.append("id=").append(id);
        sb.append(", innerLayer='").append(innerLayer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}