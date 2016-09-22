package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;
import java.util.Objects;

public class PalletDto {

    private Long id;

    @Size(max = 50)
    private String pallet;

    public PalletDto() {
    }

    public PalletDto(Long id) {
        this.id = id;
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
        PalletDto palletDto = (PalletDto) o;
        return Objects.equals(pallet, palletDto.pallet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pallet);
    }

    @Override
    public String toString() {
        return "PalletDto{" + "id=" + id +
                ", pallet='" + pallet + '\'' +
                '}';
    }
}