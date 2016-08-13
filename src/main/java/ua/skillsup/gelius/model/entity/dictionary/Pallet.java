package ua.skillsup.gelius.model.entity.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity       //  Поддон
@Table(name = "PALLET")
public class Pallet {

    @Id
    @Column(name = "PALLET_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 50)
    @Column(name = "PALLET")
    private String pallet;

    public Pallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPallet() {
        return pallet;
    }

    public void setPallet(String pallet) {
        this.pallet = pallet;
    }

    @Override
    public String toString() {
        return "Pallet{" +
                "id=" + id +
                ", pallet='" + pallet + '\'' +
                '}';
    }
}