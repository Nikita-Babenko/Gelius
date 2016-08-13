package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity       //  Целлюлозный слой
@Table(name = "cellulose_layer")
public class CelluloseLayer {

    @Id
    @Column(name = "cellulouse_layer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 50)
    @Column(name = "cellulouse_layer")
    private String cellulouseLayer;

    public CelluloseLayer() {
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
    public String toString() {
        final StringBuilder sb = new StringBuilder("CelluloseLayer{");
        sb.append("id=").append(id);
        sb.append(", cellulouseLayer='").append(cellulouseLayer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}