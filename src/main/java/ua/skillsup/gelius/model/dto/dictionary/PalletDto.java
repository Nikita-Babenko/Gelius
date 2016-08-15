package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;

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
    public String toString() {
        final StringBuilder sb = new StringBuilder("PalletDto{");
        sb.append("id=").append(id);
        sb.append(", pallet='").append(pallet).append('\'');
        sb.append('}');
        return sb.toString();
    }
}