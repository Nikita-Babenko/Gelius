package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;
import java.util.Objects;

public class FaceLayerDto {

    private Long id;

    @Size(max = 50)
    private String faceLayer;

    public FaceLayerDto() {
    }

    public FaceLayerDto(Long id) {
        this.id = id;
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
        FaceLayerDto that = (FaceLayerDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FaceLayerDto{");
        sb.append("id=").append(id);
        sb.append(", faceLayer='").append(faceLayer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}