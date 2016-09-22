package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackingDto that = (PackingDto) o;
        return Objects.equals(packing, that.packing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packing);
    }

    @Override
    public String toString() {
        return "PackingDto{" + "id=" + id +
                ", packing='" + packing + '\'' +
                '}';
    }
}