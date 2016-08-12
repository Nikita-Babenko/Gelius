package ua.skillsup.gelius.model.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity       //  Тип картона
@Table(name = "CARDBOARD_TYPE")
public class CardboardType {

    @Id
    @Column(name = "CARDBOARD_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 50)
    @Column(name = "CARDBOARD_TYPE")
    private String cardboardType;


    public CardboardType(String cardboardType) {
        this.cardboardType = cardboardType;
    }

    public CardboardType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardboardType() {
        return cardboardType;
    }

    public void setCardboardType(String ctype) {
        this.cardboardType = ctype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardboardType)) return false;
        CardboardType that = (CardboardType) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getCardboardType(), that.getCardboardType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCardboardType());
    }

    @Override
    public String toString() {
        return "CardboardType{" +
                "id=" + id +
                ", cardboardType='" + cardboardType + '\'' +
                '}';
    }
}