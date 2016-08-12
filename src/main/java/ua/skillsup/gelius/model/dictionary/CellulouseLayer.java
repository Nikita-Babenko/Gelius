package ua.skillsup.gelius.model.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity       //  Целлюлозный слой
@Table(name = "CELLULOUSE_LAYER")
public class CellulouseLayer {

    @Id
    @Column(name = "CELLULOUSE_LAYER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 50)
    @Column(name = "CELLULOUSE_LAYER")
    private String cellulouseLayer;

    public CellulouseLayer(String cellulosicLayer) {
        this.cellulouseLayer = cellulosicLayer;
    }

    public CellulouseLayer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCellulouseLayer() {
        return cellulouseLayer;
    }

    public void setCellulouseLayer(String cellulosicLayer) {
        this.cellulouseLayer = cellulosicLayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CellulouseLayer)) return false;
        CellulouseLayer that = (CellulouseLayer) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getCellulouseLayer(), that.getCellulouseLayer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCellulouseLayer());
    }

    @Override
    public String toString() {
        return "CellulouseLayer{" +
                "id=" + id +
                ", cellulouseLayer='" + cellulouseLayer + '\'' +
                '}';
    }
}