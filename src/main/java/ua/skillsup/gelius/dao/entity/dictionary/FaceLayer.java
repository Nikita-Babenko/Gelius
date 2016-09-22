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
        FaceLayer faceLayer1 = (FaceLayer) o;
        return Objects.equals(faceLayer, faceLayer1.faceLayer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faceLayer);
    }

    @Override
    public String toString() {
        return "FaceLayer{" + "id=" + id +
                ", faceLayer='" + faceLayer + '\'' +
                '}';
    }
}