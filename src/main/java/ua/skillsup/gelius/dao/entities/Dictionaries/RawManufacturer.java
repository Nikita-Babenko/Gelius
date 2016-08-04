package ua.skillsup.gelius.dao.entities.Dictionaries;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity       //  Производитель сырья
@Table(name = "RAW_MANUFACTURER")
public class RawManufacturer {

    @Id
    @Column(name = "RAW_MANUFACTURER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 50)
    @Column(name = "MANUFACTURER")
    private String manufacturer;

    /*public RawManufacturer(Long id, String manufacturer) {
        this.id = id;
        this.manufacturer = manufacturer;
    }*/

    public RawManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public RawManufacturer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RawManufacturer)) return false;
        RawManufacturer that = (RawManufacturer) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getManufacturer(), that.getManufacturer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getManufacturer());
    }

    @Override
    public String toString() {
        return "RawManufacturer{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}