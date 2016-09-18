package ua.skillsup.gelius.dao.entity.dictionary;

import javax.persistence.*;
import java.util.Objects;

@Entity       // Соединение клапана
@Table(name = "connection_valve")
public class ConnectionValve {

    @Id
    @Column(name = "connection_valve_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public void setConnectionValve(String connectionValve) {
        this.connectionValve = connectionValve;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConnectionValve that = (ConnectionValve) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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