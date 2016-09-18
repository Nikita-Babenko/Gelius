package ua.skillsup.gelius.dao.entity.dictionary;

import javax.persistence.*;
import java.util.Objects;

@Entity       //  Размещение на поддоне
@Table(name = "pallet_placement")
public class PalletPlacement {

    @Id
    @Column(name = "pallet_placement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pallet_placement")
    private String palletPlacement;

    public PalletPlacement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPalletPlacement() {
        return palletPlacement;
    }

    public void setPlacement(String palletPlacement) {
        this.palletPlacement = palletPlacement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PalletPlacement that = (PalletPlacement) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PalletPlacement{");
        sb.append("id=").append(id);
        sb.append(", palletPlacement='").append(palletPlacement).append('\'');
        sb.append('}');
        return sb.toString();
    }
}