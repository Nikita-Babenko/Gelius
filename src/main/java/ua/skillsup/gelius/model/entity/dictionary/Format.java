package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;

@Entity       //  Формат
@Table(name = "format")
public class Format {

    @Id
    @Column(name = "format_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    public String toString() {
        final StringBuilder sb = new StringBuilder("Format{");
        sb.append("id=").append(id);
        sb.append(", format='").append(format).append('\'');
        sb.append('}');
        return sb.toString();
    }
}