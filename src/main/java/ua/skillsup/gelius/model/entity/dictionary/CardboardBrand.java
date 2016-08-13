package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity       // Марка картона
@Table(name = "cardboard_brand")
public class CardboardBrand {

    @Id
    @Column(name = "cardboard_brand_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 50)
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

    public void setCardboardBrand(String cardboardBrand) {
        this.cardboardBrand = cardboardBrand;
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