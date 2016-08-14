package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;

public class CelluloseLayerDto {

    private Long id;

    @Size(max = 50)
    private String celluloseLayer;

    public CelluloseLayerDto() {
    }

    public CelluloseLayerDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCelluloseLayer() {
        return celluloseLayer;
    }

    public void setCelluloseLayer(String cellulosicLayer) {
        this.celluloseLayer = cellulosicLayer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CelluloseLayerDto{");
        sb.append("id=").append(id);
        sb.append(", celluloseLayer='").append(celluloseLayer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}