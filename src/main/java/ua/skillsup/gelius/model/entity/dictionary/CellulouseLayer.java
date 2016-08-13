package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;

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
    public String toString() {
        return "CellulouseLayer{" +
                "id=" + id +
                ", cellulouseLayer='" + cellulouseLayer + '\'' +
                '}';
    }
}