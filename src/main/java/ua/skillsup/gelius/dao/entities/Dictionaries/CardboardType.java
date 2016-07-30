
package ua.skillsup.gelius.dao.entities.Dictionaries;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity       //  Тип картона
@Table(name = "CARDBOARD_TYPE")
public class CardboardType {


    @Id
    @Column(name = "CTYPE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 50)
    @Column(name = "CTYPE")
    private String ctype;

    public CardboardType(Long id, String ctype) {
        this.id = id;
        this.ctype = ctype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardboardType)) return false;
        CardboardType that = (CardboardType) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getCtype(), that.getCtype());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCtype());
    }

    @Override
    public String toString() {
        return "CardboardType{" +
                "id=" + id +
                ", ctype='" + ctype + '\'' +
                '}';
    }
}