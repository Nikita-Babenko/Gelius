package ua.skillsup.gelius.dao.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ORDER")
public class Order {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "CLIENT_ID")
    private Client client;
    @Column(name = "REQUEST_ID")
    private Request request;
    @Column(name = "SHIP_DATA")
    private LocalDate shipDate;

}
