
package ua.skillsup.gelius.dao.entities.Dictionaries;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity       //  Целлюлозный слой
@Table(name = "CELLULOCIS_LAYER")
public class CellulosicLayer {


    @Id
    @Column(name = "CELLULOCIS_LAYER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 50)
    @Column(name = "CELLULOCIS_LAYER")
    private String cellulosicLayer;

    public CellulosicLayer(Long id, String cellulosicLayer) {
        this.id = id;
        this.cellulosicLayer = cellulosicLayer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCellulosicLayer() {
        return cellulosicLayer;
    }

    public void setCellulosicLayer(String cellulosicLayer) {
        this.cellulosicLayer = cellulosicLayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CellulosicLayer)) return false;
        CellulosicLayer that = (CellulosicLayer) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getCellulosicLayer(), that.getCellulosicLayer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCellulosicLayer());
    }

    @Override
    public String toString() {
        return "CELLULOCIS_LAYER{" +
                "id=" + id +
                ", cellulosicLayer='" + cellulosicLayer + '\'' +
                '}';
    }
}