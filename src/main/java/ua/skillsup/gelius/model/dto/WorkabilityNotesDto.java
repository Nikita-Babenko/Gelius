package ua.skillsup.gelius.model.dto;

import ua.skillsup.gelius.model.dto.dictionary.WorkabilityDto;

import javax.validation.constraints.Size;

public class WorkabilityNotesDto {

    private Long id;

    private ProductDto product;

    private WorkabilityDto serviceCenter;

    @Size(max = 100, message = "примечание к рабочему центру не может превышать {max} символов")
    private String note;

    public WorkabilityNotesDto() {
    }

    public WorkabilityNotesDto(Long id) {
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

    public WorkabilityDto getServiceCenter() {
        return serviceCenter;
    }

    public void setServiceCenter(WorkabilityDto serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WorkabilityNotesDto{");
        sb.append("id=").append(id);
        sb.append(", product=").append(product);
        sb.append(", serviceCenter=").append(serviceCenter);
        sb.append(", note=").append(note);
        sb.append('}');
        return sb.toString();
    }
}
