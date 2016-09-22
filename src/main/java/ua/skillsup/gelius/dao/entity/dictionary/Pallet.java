package ua.skillsup.gelius.dao.entity.dictionary;

import javax.persistence.*;
import java.util.Objects;

@Entity       //  Поддон
@Table(name = "pallet")
public class Pallet {

    @Id
    @Column(name = "pallet_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pallet")
    private String pallet;

    public Pallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPallet() {
        return pallet;
    }

    public void setPallet(String pallet) {
        this.pallet = pallet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pallet pallet1 = (Pallet) o;
        return Objects.equals(pallet, pallet1.pallet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pallet);
    }

    @Override
    public String toString() {
        return "Pallet{" + "id=" + id +
                ", pallet='" + pallet + '\'' +
                '}';
    }
}