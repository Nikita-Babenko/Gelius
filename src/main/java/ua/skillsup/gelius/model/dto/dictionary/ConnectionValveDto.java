package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;
import java.util.Objects;

public class ConnectionValveDto {

    private Long id;

    @Size(max = 50)
    private String connectionValve;

    public ConnectionValveDto() {
    }

    public ConnectionValveDto(Long id) {
        this.id = id;
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

    public void setConnectionValve(String paperType) {
        this.connectionValve = paperType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConnectionValveDto that = (ConnectionValveDto) o;
        return Objects.equals(connectionValve, that.connectionValve);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectionValve);
    }

    @Override
    public String toString() {
        return "ConnectionValveDto{" + "id=" + id +
                ", connectionValve='" + connectionValve + '\'' +
                '}';
    }
}