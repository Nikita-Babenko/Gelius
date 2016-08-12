package ua.skillsup.gelius.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "REQUESTS")
public class Request {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "ORDER_ID")
    private Order order;
    @Column(name = "PRODUCTS_LIST")
    @OneToMany(mappedBy = "id")
    private List<Product> productsList;
    @Column(name = "READINESS_DATE")
    private LocalDate readinessDate;

    public Request() {
    }
}
