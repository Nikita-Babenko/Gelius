
package ua.skillsup.gelius.dao.entities.Dictionaries;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity       //  Размещение на поддоне
@Table(name = "PLACEMENT")
public class Placement {


    @Id
    @Column(name = "PLACEMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 50)
    @Column(name = "PLACEMENT")
    private String placement;

    public Placement(Long id, String placement) {
        this.id = id;
        this.placement = placement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Placement)) return false;
        Placement that = (Placement) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getPlacement(), that.getPlacement());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPlacement());
    }

    @Override
    public String toString() {
        return "PLACEMENT{" +
                "id=" + id +
                ", placement='" + placement + '\'' +
                '}';
    }
}