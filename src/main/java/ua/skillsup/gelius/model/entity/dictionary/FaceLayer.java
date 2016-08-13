package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;

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
    public String toString() {
        return "FaceLayer{" +
                "id=" + id +
                ", faceLayer='" + faceLayer + '\'' +
                '}';
    }
}