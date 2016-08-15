package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;

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
    public String toString() {
        final StringBuilder sb = new StringBuilder("InnerLayerDto{");
        sb.append("id=").append(id);
        sb.append(", innerLayer='").append(innerLayer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}