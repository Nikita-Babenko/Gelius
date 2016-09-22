package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;
import java.util.Objects;

public class InnerLayerDto {

    private Long id;

    @Size(max = 50)
    private String innerLayer;

    public InnerLayerDto() {
    }

    public InnerLayerDto(Long id) {
        this.id = id;
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
        InnerLayerDto that = (InnerLayerDto) o;
        return Objects.equals(innerLayer, that.innerLayer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(innerLayer);
    }

    @Override
    public String toString() {
        return "InnerLayerDto{" + "id=" + id +
                ", innerLayer='" + innerLayer + '\'' +
                '}';
    }
}