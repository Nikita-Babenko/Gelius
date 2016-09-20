package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;
import java.util.Objects;

public class CardboardBrandDto {

    private Long id;

    @Size(max = 50)
    private String cardboardBrand;

    public CardboardBrandDto() {
    }

    public CardboardBrandDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardboardBrand() {
        return cardboardBrand;
    }

    public void setCardboardBrand(String cardboardBrand) {
        this.cardboardBrand = cardboardBrand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardboardBrandDto that = (CardboardBrandDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CardboardBrandDto{");
        sb.append("id=").append(id);
        sb.append(", cardboardBrand='").append(cardboardBrand).append('\'');
        sb.append('}');
        return sb.toString();
    }
}