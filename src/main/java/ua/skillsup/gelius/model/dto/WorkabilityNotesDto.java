package ua.skillsup.gelius.model.dto;

import ua.skillsup.gelius.model.dto.dictionary.WorkabilityDto;

public class WorkabilityNotesDto {

    private Long id;

    private ProductDto product;

    private WorkabilityDto sericeCenter;

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

    public WorkabilityDto getSericeCenter() {
        return sericeCenter;
    }

    public void setSericeCenter(WorkabilityDto sericeCenter) {
        this.sericeCenter = sericeCenter;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WorkabilityNotesDto{");
        sb.append("id=").append(id);
        sb.append(", product=").append(product);
        sb.append(", sericeCenter=").append(sericeCenter);
        sb.append('}');
        return sb.toString();
    }
}
