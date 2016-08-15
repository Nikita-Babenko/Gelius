package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;

public class PackingDto {

    private Long id;

    @Size(max = 50)
    private String packing;

    public PackingDto() {
    }

    public PackingDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PackingDto{");
        sb.append("id=").append(id);
        sb.append(", packing='").append(packing).append('\'');
        sb.append('}');
        return sb.toString();
    }
}