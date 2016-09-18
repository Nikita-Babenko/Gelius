package ua.skillsup.gelius.dao.entity.dictionary;

import javax.persistence.*;
import java.util.Objects;

@Entity       // Марка картона
@Table(name = "cardboard_brand")
public class CardboardBrand {

    @Id
    @Column(name = "cardboard_brand_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cardboard_brand")
    private String cardboardBrand;

    public CardboardBrand() {
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

    public void setCardboardBrand(String cardBoardBrand) {
        this.cardboardBrand = cardBoardBrand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardboardBrand that = (CardboardBrand) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CardboardBrand{");
        sb.append("id=").append(id);
        sb.append(", cardboardBrand='").append(cardboardBrand).append('\'');
        sb.append('}');
        return sb.toString();
    }
}