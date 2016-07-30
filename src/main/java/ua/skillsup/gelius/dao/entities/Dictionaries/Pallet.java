
package ua.skillsup.gelius.dao.entities.Dictionaries;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity       //  Поддон
@Table(name = "PALLET")
public class Pallet {


    @Id
    @Column(name = "PALLET_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 50)
    @Column(name = "PALLET")
    private String pallet;

    public Pallet(Long id, String pallet) {
        this.id = id;
        this.pallet = pallet;
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
        if (!(o instanceof Pallet)) return false;
        Pallet that = (Pallet) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getPallet(), that.getPallet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPallet());
    }

    @Override
    public String toString() {
        return "PALLET{" +
                "id=" + id +
                ", pallet='" + pallet + '\'' +
                '}';
    }
}