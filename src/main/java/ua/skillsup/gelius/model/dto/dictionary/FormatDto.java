package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;

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
    public String toString() {
        final StringBuilder sb = new StringBuilder("FormatDto{");
        sb.append("id=").append(id);
        sb.append(", format='").append(format).append('\'');
        sb.append('}');
        return sb.toString();
    }
}