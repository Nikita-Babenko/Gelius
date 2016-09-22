package ua.skillsup.gelius.dao.entity;

import ua.skillsup.gelius.dao.entity.dictionary.Producibility;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProducibilityNotes that = (ProducibilityNotes) o;
        return Objects.equals(product.getId(), that.product.getId()) &&
                Objects.equals(serviceCenter, that.serviceCenter) &&
                Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product.getId(), serviceCenter, note);
    }

    @Override
    public String toString() {
        return "ProducibilityNotes{" + "id=" + id +
                ", product=" + product.getId() +
                ", serviceCenter=" + serviceCenter +
                ", note='" + note + '\'' +
                '}';
    }
}
