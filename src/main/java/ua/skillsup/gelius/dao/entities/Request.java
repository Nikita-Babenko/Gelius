package ua.skillsup.gelius.dao.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "REQUEST")
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
    @Column(name = "READINESS_DATA")
    private LocalDate readinessData;
}
