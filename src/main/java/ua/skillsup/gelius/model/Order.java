package ua.skillsup.gelius.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Table(name = "ORDERS")
public class Order {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CLIENT_ID")
    @OneToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @Column(name = "SHIP_DATE")
    private LocalDate shipDate;

    @Size(max = 20)
    @Column(name = "STATUS")
    private String status;

    public Order() {
    }

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

    public LocalDate getShipDate() {
        return shipDate;
    }

    public void setShipDate(LocalDate shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClient(), getShipDate(), getStatus());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getId(), order.getId()) &&
                Objects.equals(getClient(), order.getClient()) &&
                Objects.equals(getShipDate(), order.getShipDate()) &&
                Objects.equals(getStatus(), order.getStatus());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", shipDate=" + shipDate +
                ", status='" + status + '\'' +
                '}';
    }

}
