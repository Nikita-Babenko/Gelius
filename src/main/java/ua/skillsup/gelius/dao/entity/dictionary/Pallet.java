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
        Pallet pallet = (Pallet) o;
        return Objects.equals(id, pallet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pallet{");
        sb.append("id=").append(id);
        sb.append(", pallet='").append(pallet).append('\'');
        sb.append('}');
        return sb.toString();
    }
}