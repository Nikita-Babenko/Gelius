package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;

public class WorkabilityDto {

    private Long id;

    @Size(max = 50, message = "наименование рабочего центра не может превышать {max} символов")
    private String serviceCenter;

    private Integer groupPriority;

    private Integer elementPriority;

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

    public Integer getGroupPriority() {
        return groupPriority;
    }

    public void setGroupPriority(Integer groupPriority) {
        this.groupPriority = groupPriority;
    }

    public Integer getElementPriority() {
        return elementPriority;
    }

    public void setElementPriority(Integer elementPriority) {
        this.elementPriority = elementPriority;
    }

    @Override
    public String toString() {
        return "WorkabilityDto{" +
            "id=" + id +
            ", serviceCenter='" + serviceCenter + '\'' +
            ", groupPriority=" + groupPriority +
            ", elementPriority=" + elementPriority +
            '}';
    }
}