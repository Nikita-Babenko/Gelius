package ua.skillsup.gelius.dao.entity.dictionary;

import javax.persistence.*;

@Entity       //  Рабочий центр
@Table(name = "workability")
public class Workability {

    @Id
    @Column(name = "workability_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "service_center")
    private String serviceCenter;

    @Column(name = "group_priority")
    private Integer groupPriority;

    @Column(name = "element_priority")
    private Integer elementPriority;

    public Workability() {
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
        return "Workability{" +
            "id=" + id +
            ", serviceCenter='" + serviceCenter + '\'' +
            ", groupPriority=" + groupPriority +
            ", elementPriority=" + elementPriority +
            '}';
    }
}