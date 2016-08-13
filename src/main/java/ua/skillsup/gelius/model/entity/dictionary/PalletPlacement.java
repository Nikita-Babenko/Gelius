package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity       //  Размещение на поддоне
@Table(name = "pallet_placement")
public class PalletPlacement {

    @Id
    @Column(name = "pallet_placement_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 50)
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
    public String toString() {
        final StringBuilder sb = new StringBuilder("PalletPlacement{");
        sb.append("id=").append(id);
        sb.append(", palletPlacement='").append(palletPlacement).append('\'');
        sb.append('}');
        return sb.toString();
    }
}