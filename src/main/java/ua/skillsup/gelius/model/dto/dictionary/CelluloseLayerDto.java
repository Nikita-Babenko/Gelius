package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CelluloseLayerDto that = (CelluloseLayerDto) o;
        return Objects.equals(celluloseLayer, that.celluloseLayer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(celluloseLayer);
    }

    @Override
    public String toString() {
        return "CelluloseLayerDto{" + "id=" + id +
                ", celluloseLayer='" + celluloseLayer + '\'' +
                '}';
    }
}