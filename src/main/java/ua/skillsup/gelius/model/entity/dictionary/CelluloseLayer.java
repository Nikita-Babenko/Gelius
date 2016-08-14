package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;

@Entity       //  Целлюлозный слой
@Table(name = "cellulose_layer")
public class CelluloseLayer {

    @Id
    @Column(name = "cellulose_layer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public void setCelluloseLayer(String cellulosicLayer) {
        this.celluloseLayer = cellulosicLayer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CelluloseLayer{");
        sb.append("id=").append(id);
        sb.append(", celluloseLayer='").append(celluloseLayer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}