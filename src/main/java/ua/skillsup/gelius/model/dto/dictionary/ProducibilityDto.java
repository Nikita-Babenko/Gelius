package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;
import java.util.Objects;

public class ProducibilityDto {

    private Long id;

    @Size(max = 50, message = "наименование рабочего центра не может превышать {max} символов")
    private String serviceCenter;

    private Integer groupPriority;

    private Integer elementPriority;

    public ProducibilityDto() {
    }

    public ProducibilityDto(Long id) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProducibilityDto that = (ProducibilityDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProducibilityDto{");
        sb.append("id=").append(id);
        sb.append(", serviceCenter='").append(serviceCenter).append('\'');
        sb.append(", groupPriority=").append(groupPriority);
        sb.append(", elementPriority=").append(elementPriority);
        sb.append('}');
        return sb.toString();
    }
}