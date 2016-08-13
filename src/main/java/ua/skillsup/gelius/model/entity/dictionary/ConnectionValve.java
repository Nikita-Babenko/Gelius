package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity       // Соединение клапана
@Table(name = "CONNECTION_VALVE")
public class ConnectionValve {

    @Id
    @Column(name = "CONNECTION_VALVE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 50)
    @Column(name = "CONNECTION_VALVE")
    private String connectionValve;

    public ConnectionValve() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConnectionValve() {
        return connectionValve;
    }

    public void setBrand(String paperType) {
        this.connectionValve = paperType;
    }

    @Override
    public String toString() {
        return "ConnectionValve{" +
                "id=" + id +
                ", connectionValve='" + connectionValve + '\'' +
                '}';
    }
}