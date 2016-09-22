package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;
import java.util.Objects;

public class FormatDto {

    private Long id;

    @Size(max = 50)
    private String format;

    public FormatDto() {
    }

    public FormatDto(Long id) {
        this.id = id;
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
        FormatDto formatDto = (FormatDto) o;
        return Objects.equals(format, formatDto.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(format);
    }

    @Override
    public String toString() {
        return "FormatDto{" + "id=" + id +
                ", format='" + format + '\'' +
                '}';
    }
}