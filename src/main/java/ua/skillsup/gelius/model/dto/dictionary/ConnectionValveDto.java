package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;

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
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConnectionValveDto{");
        sb.append("id=").append(id);
        sb.append(", connectionValve='").append(connectionValve).append('\'');
        sb.append('}');
        return sb.toString();
    }
}