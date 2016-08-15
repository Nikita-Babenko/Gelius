package ua.skillsup.gelius.model.entity;

import ua.skillsup.gelius.model.entity.dictionary.Workability;

import javax.persistence.*;

@Entity
@Table(name = "workability_notes")
public class WorkabilityNotes {

    @Id
    @Column(name = "workability_notes_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="service_center")
    private Workability sericeCenter;

    public WorkabilityNotes() {
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

    public Workability getSericeCenter() {
        return sericeCenter;
    }

    public void setSericeCenter(Workability sericeCenter) {
        this.sericeCenter = sericeCenter;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WorkabilityNotes{");
        sb.append("id=").append(id);
        sb.append(", product=").append(product);
        sb.append(", sericeCenter=").append(sericeCenter);
        sb.append('}');
        return sb.toString();
    }
}
