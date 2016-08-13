package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity       // Соединение клапана
@Table(name = "connection_valve")
public class ConnectionValve {

    @Id
    @Column(name = "connection_valve_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 50)
    @Column(name = "connection_valve")
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
        final StringBuilder sb = new StringBuilder("ConnectionValve{");
        sb.append("id=").append(id);
        sb.append(", connectionValve='").append(connectionValve).append('\'');
        sb.append('}');
        return sb.toString();
    }
}