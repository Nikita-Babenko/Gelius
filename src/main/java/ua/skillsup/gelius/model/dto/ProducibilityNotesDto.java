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
        return Objects.equals(product.getId(), that.product.getId()) &&
                Objects.equals(serviceCenter, that.serviceCenter) &&
                Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product.getId(), serviceCenter, note);
    }

    @Override
    public String toString() {
        return "ProducibilityNotesDto{" + "id=" + id +
                ", product=" + product.getId() +
                ", serviceCenter=" + serviceCenter +
                ", note='" + note + '\'' +
                '}';
    }
}
