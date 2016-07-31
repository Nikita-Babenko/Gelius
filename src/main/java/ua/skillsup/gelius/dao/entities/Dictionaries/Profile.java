package ua.skillsup.gelius.dao.entities.Dictionaries;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity       //  Способ упаковки
@Table(name = "PACKING")
public class Profile {

    @Id
    @Column(name = "PACKING_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 50)
    @Column(name = "PACKING")
    private String packing;

    public Profile(Long id, String packing) {
        this.id = id;
        this.packing = packing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile that = (Profile) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getPacking(), that.getPacking());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPacking());
    }

    @Override
    public String toString() {
        return "Packing{" +
                "id=" + id +
                ", packing='" + packing + '\'' +
                '}';
    }
}