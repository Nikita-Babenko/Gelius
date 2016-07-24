package ua.skillsup.gelius.dto;

import ua.skillsup.gelius.model.entities.Client;
import ua.skillsup.gelius.model.entities.Request;

import java.time.LocalDate;
import java.util.Objects;

public class OrderDto {
    private Long id;
    private Client client;
    private Request request;
    private LocalDate shipDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public LocalDate getShipDate() {
        return shipDate;
    }

    public void setShipDate(LocalDate shipDate) {
        this.shipDate = shipDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return Objects.equals(id, orderDto.id) &&
                Objects.equals(client, orderDto.client) &&
                Objects.equals(request, orderDto.request) &&
                Objects.equals(shipDate, orderDto.shipDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, request, shipDate);
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", client=" + client +
                ", request=" + request +
                ", shipDate=" + shipDate +
                '}';
    }
}
