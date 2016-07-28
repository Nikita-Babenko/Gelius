package ua.skillsup.gelius.dto;

import ua.skillsup.gelius.dao.entities.Order;
import ua.skillsup.gelius.dao.entities.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class RequestDto {
    private Long id;
    private Order order;
    private List<Product> productsList;
    private LocalDate readinessData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    public LocalDate getReadinessData() {
        return readinessData;
    }

    public void setReadinessData(LocalDate readinessData) {
        this.readinessData = readinessData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestDto that = (RequestDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(order, that.order) &&
                Objects.equals(productsList, that.productsList) &&
                Objects.equals(readinessData, that.readinessData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, productsList, readinessData);
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "id=" + id +
                ", order=" + order +
                ", productsList=" + productsList +
                ", readinessData=" + readinessData +
                '}';
    }
}
