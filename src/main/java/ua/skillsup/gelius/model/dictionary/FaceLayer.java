package ua.skillsup.gelius.model.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity       //  Лицевой слой
@Table(name = "FACE_LAYER")
public class FaceLayer {

    @Id
    @Column(name = "FACE_LAYER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 50)
    @Column(name = "FACE_LAYER")
    private String faceLayer;

    public FaceLayer(String faceLayer) {
        this.faceLayer = faceLayer;
    }

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
        if (!(o instanceof FaceLayer)) return false;
        FaceLayer that = (FaceLayer) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getFaceLayer(), that.getFaceLayer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFaceLayer());
    }

    @Override
    public String toString() {
        return "FaceLayer{" +
                "id=" + id +
                ", faceLayer='" + faceLayer + '\'' +
                '}';
    }
}