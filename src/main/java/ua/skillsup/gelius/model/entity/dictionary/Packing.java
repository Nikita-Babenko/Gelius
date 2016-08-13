package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity       //  Способ упаковки
@Table(name = "PACKING")
public class Packing {

    @Id
    @Column(name = "PACKING_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 50)
    @Column(name = "PACKING")
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
    public String toString() {
        return "Packing{" +
                "id=" + id +
                ", packing='" + packing + '\'' +
                '}';
    }
}