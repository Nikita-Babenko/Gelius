package ua.skillsup.gelius.dao.entity.dictionary;

import javax.persistence.*;
import java.util.Objects;

@Entity       //  Способ упаковки
@Table(name = "packing")
public class Packing {

    @Id
    @Column(name = "packing_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "packing")
    private String packing;

    public Packing() {
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
        if (o == null || getClass() != o.getClass()) return false;
        Packing packing1 = (Packing) o;
        return Objects.equals(packing, packing1.packing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packing);
    }

    @Override
    public String toString() {
        return "Packing{" + "id=" + id +
                ", packing='" + packing + '\'' +
                '}';
    }
}