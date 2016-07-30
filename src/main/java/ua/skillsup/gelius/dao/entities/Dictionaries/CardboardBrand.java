
package ua.skillsup.gelius.dao.entities.Dictionaries;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity       // Марка картона
@Table(name = "CARDBOARD_BRAND")
public class CardboardBrand {


    @Id
    @Column(name = "BRAND_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 50)
    @Column(name = "BRAND")
    private String brand;

    public CardboardBrand(Long id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardboardBrand)) return false;
        CardboardBrand that = (CardboardBrand) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getBrand(), that.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand());
    }

    @Override
    public String toString() {
        return "CardboardBrand{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                '}';
    }
}