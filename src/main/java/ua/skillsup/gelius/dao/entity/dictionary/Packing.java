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
        Packing packing = (Packing) o;
        return Objects.equals(id, packing.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Packing{");
        sb.append("id=").append(id);
        sb.append(", packing='").append(packing).append('\'');
        sb.append('}');
        return sb.toString();
    }
}