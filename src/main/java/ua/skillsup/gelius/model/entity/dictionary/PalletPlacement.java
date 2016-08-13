package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity       //  Размещение на поддоне
@Table(name = "PALLET_PLACEMENT")
public class PalletPlacement {

    @Id
    @Column(name = "PALLET_PLACEMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 50)
    @Column(name = "PALLET_PLACEMENT")
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
        return "PalletPlacement{" +
                "id=" + id +
                ", palletPlacement='" + palletPlacement + '\'' +
                '}';
    }
}