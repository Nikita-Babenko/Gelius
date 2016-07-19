package ua.skillsup.gelius.dao.entities;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTS")
public class product {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
