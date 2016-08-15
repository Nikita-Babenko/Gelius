package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;

public class WorkabilityDto {

    private Long id;

    @Size(max = 50)
    private String serviceCenter;

    public WorkabilityDto() {
    }

    public WorkabilityDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceCenter() {
        return serviceCenter;
    }

    public void setServiceCenter(String serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WorkabilityDto{");
        sb.append("id=").append(id);
        sb.append(", serviceCenter='").append(serviceCenter).append('\'');
        sb.append('}');
        return sb.toString();
    }
}