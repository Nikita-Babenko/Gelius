package ua.skillsup.gelius.dao.entity;

import ua.skillsup.gelius.dao.entity.dictionary.Producibility;

import javax.persistence.*;

@Entity
@Table(name = "producibility_notes")
public class ProducibilityNotes {

    @Id
    @Column(name = "producibility_notes_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="service_center")
    private Producibility serviceCenter;

    @Column(name = "notes")
    private String note;

    public ProducibilityNotes() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Producibility getServiceCenter() {
        return serviceCenter;
    }

    public void setServiceCenter(Producibility serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
