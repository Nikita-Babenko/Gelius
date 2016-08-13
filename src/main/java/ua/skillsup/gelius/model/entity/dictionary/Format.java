package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity       //  Формат
@Table(name = "FORMAT")
public class Format {

    @Id
    @Column(name = "FORMAT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 50)
    @Column(name = "FORMAT")
    private String format;

    public Format() {
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
    public String toString() {
        return "Format{" +
                "id=" + id +
                ", format='" + format + '\'' +
                '}';
    }
}