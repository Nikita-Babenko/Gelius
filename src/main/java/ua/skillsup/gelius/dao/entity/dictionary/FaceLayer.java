package ua.skillsup.gelius.dao.entity.dictionary;

import javax.persistence.*;
import java.util.Objects;

@Entity       //  Лицевой слой
@Table(name = "face_layer")
public class FaceLayer {

    @Id
    @Column(name = "face_layer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "face_layer")
    private String faceLayer;

    public FaceLayer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFaceLayer() {
        return faceLayer;
    }

    public void setFaceLayer(String faceLayer) {
        this.faceLayer = faceLayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FaceLayer faceLayer = (FaceLayer) o;
        return Objects.equals(id, faceLayer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FaceLayer{");
        sb.append("id=").append(id);
        sb.append(", faceLayer='").append(faceLayer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}