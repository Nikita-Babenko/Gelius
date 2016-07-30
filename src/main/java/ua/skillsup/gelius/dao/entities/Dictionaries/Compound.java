
package ua.skillsup.gelius.dao.entities.Dictionaries;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity       //  Соединенине клапана
@Table(name = "COMPOUND")
public class Compound {


    @Id
    @Column(name = "COMPOUND_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 50)
    @Column(name = "COMPOUND")
    private String compound;

    public Compound(Long id, String compound) {
        this.id = id;
        this.compound = compound;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompound() {
        return compound;
    }

    public void setCompound(String compound) {
        this.compound = compound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compound)) return false;
        Compound that = (Compound) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getCompound(), that.getCompound());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCompound());
    }

    @Override
    public String toString() {
        return "COMPOUND{" +
                "id=" + id +
                ", compound='" + compound + '\'' +
                '}';
    }
}