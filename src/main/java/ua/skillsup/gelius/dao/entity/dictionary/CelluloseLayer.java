package ua.skillsup.gelius.dao.entity.dictionary;

import javax.persistence.*;
import java.util.Objects;

@Entity       //  Целлюлозный слой
@Table(name = "cellulose_layer")
public class CelluloseLayer {

    @Id
    @Column(name = "cellulose_layer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cellulose_layer")
    private String celluloseLayer;

    public CelluloseLayer() {
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

    public void setCelluloseLayer(String celluloseLayer) {
        this.celluloseLayer = celluloseLayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CelluloseLayer that = (CelluloseLayer) o;
        return Objects.equals(celluloseLayer, that.celluloseLayer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(celluloseLayer);
    }

    @Override
    public String toString() {
        return "CelluloseLayer{" + "id=" + id +
                ", celluloseLayer='" + celluloseLayer + '\'' +
                '}';
    }
}