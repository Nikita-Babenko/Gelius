package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity       //  Профиль
@Table(name = "WORKABILITY")
public class Workability {

    @Id
    @Column(name = "WORKABILITY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 50)
    @Column(name = "SERVICE_CENTER")
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
        return "Workability{" +
                "id=" + id +
                ", serviceCenter='" + serviceCenter + '\'' +
                '}';
    }
}