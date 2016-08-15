package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;

@Entity       // Марка картона
@Table(name = "cardboard_brand")
public class CardBoardBrand {

    @Id
    @Column(name = "cardboard_brand_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cardboard_brand")
    private String cardBoardBrand;

    public CardBoardBrand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardboardBrand() {
        return cardBoardBrand;
    }

    public void setCardboardBrand(String cardBoardBrand) {
        this.cardBoardBrand = cardBoardBrand;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CardBoardBrand{");
        sb.append("id=").append(id);
        sb.append(", cardboardBrand='").append(cardBoardBrand).append('\'');
        sb.append('}');
        return sb.toString();
    }
}