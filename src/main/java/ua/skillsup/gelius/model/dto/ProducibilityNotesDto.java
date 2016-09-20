package ua.skillsup.gelius.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ua.skillsup.gelius.model.dto.dictionary.ProducibilityDto;

import javax.validation.constraints.Size;
import java.util.Objects;

public class ProducibilityNotesDto {

    private Long id;

    @JsonBackReference
    private ProductDto product;

    private ProducibilityDto serviceCenter;

    @Size(max = 100, message = "примечание к рабочему центру не может превышать {max} символов")
    private String note;

    public ProducibilityNotesDto() {
    }

    public ProducibilityNotesDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public ProducibilityDto getServiceCenter() {
        return serviceCenter;
    }

    public void setServiceCenter(ProducibilityDto serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProducibilityNotesDto that = (ProducibilityNotesDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProducibilityNotesDto{");
        sb.append("id=").append(id);
        sb.append(", product=").append(product.getId());
        sb.append(", serviceCenter=").append(serviceCenter);
        sb.append(", note='").append(note).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
