package ua.skillsup.gelius.dao.entity.dictionary;

import javax.persistence.*;
import java.util.Objects;

@Entity       //  Формат
@Table(name = "format")
public class Format {

    @Id
    @Column(name = "format_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "format")
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Format format = (Format) o;
        return Objects.equals(id, format.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Format{");
        sb.append("id=").append(id);
        sb.append(", format='").append(format).append('\'');
        sb.append('}');
        return sb.toString();
    }
}