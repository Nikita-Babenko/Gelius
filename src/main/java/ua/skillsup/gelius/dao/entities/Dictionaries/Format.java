
package ua.skillsup.gelius.dao.entities.Dictionaries;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity       //  Формат
@Table(name = "FORMAT")
public class Format {


    @Id
    @Column(name = "FORMAT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 50)
    @Column(name = "FORMAT ")
    private String format;

    public Format(Long id, String format) {
        this.id = id;
        this.format = format;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Format)) return false;
        Format that = (Format) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getFormat(), that.getFormat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFormat());
    }

    @Override
    public String toString() {
        return "FORMAT{" +
                "id=" + id +
                ", format='" + format + '\'' +
                '}';
    }
}