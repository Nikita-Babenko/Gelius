package ua.skillsup.gelius.dao.entities;

import javax.persistence.*;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "COMPANY_NAME", nullable = false)
    private String companyName;
    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "DESCRIPTION", nullable = false, columnDefinition = "TEXT")
    private String description;

}
