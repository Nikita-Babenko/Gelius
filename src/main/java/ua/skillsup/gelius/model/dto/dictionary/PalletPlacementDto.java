package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;
import java.util.Objects;

public class PalletPlacementDto {

    private Long id;

    @Size(max = 50)
    private String palletPlacement;

    public PalletPlacementDto() {
    }

    public PalletPlacementDto(Long id) {
        this.id = id;
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
        PalletPlacementDto that = (PalletPlacementDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PalletPlacementDto{");
        sb.append("id=").append(id);
        sb.append(", palletPlacement='").append(palletPlacement).append('\'');
        sb.append('}');
        return sb.toString();
    }
}