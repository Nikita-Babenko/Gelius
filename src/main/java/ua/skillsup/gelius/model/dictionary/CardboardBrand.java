package ua.skillsup.gelius.model.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity       // Марка картона
@Table(name = "CARDBOARD_BRAND")
public class CardboardBrand {

    @Id
    @Column(name = "CARDBOARD_BRAND_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 50)
    @Column(name = "CARDBOARD_BRAND")
    private String cardboardBrand;


    public CardboardBrand(String cardboardBrand) {
        this.cardboardBrand = cardboardBrand;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardboardBrand)) return false;
        CardboardBrand that = (CardboardBrand) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getCardboardBrand(), that.getCardboardBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCardboardBrand());
    }

    @Override
    public String toString() {
        return "CardboardBrand{" +
                "id=" + id +
                ", cardboardBrand='" + cardboardBrand + '\'' +
                '}';
    }
}