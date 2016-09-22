package ua.skillsup.gelius.dao.entity.dictionary;

import javax.persistence.*;
import java.util.Objects;

@Entity       //  Рабочий центр
@Table(name = "producibility")
public class Producibility {

    @Id
    @Column(name = "producibility_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_center")
    private String serviceCenter;

    @Column(name = "group_priority")
    private Integer groupPriority;

    @Column(name = "element_priority")
    private Integer elementPriority;

    public Producibility() {
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
        Producibility that = (Producibility) o;
        return Objects.equals(serviceCenter, that.serviceCenter) &&
                Objects.equals(groupPriority, that.groupPriority) &&
                Objects.equals(elementPriority, that.elementPriority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceCenter, groupPriority, elementPriority);
    }

    @Override
    public String toString() {
        return "Producibility{" + "id=" + id +
                ", serviceCenter='" + serviceCenter + '\'' +
                ", groupPriority=" + groupPriority +
                ", elementPriority=" + elementPriority +
                '}';
    }
}