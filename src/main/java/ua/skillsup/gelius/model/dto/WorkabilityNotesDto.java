package ua.skillsup.gelius.model.dto;

import ua.skillsup.gelius.model.entity.Product;
import ua.skillsup.gelius.model.entity.dictionary.Workability;

public class WorkabilityNotesDto {

    private Long id;

    private Product product;

    private Workability sericeCenter;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Workability getSericeCenter() {
        return sericeCenter;
    }

    public void setSericeCenter(Workability sericeCenter) {
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
