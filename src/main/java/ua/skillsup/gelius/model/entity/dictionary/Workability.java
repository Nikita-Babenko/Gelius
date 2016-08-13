package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity       //  Профиль
@Table(name = "workability")
public class Workability {

    @Id
    @Column(name = "workability_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 50)
    @Column(name = "service_center")
    private String serviceCenter;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Workability{");
        sb.append("id=").append(id);
        sb.append(", serviceCenter='").append(serviceCenter).append('\'');
        sb.append('}');
        return sb.toString();
    }
}