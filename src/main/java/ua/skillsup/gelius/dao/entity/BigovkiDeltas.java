package ua.skillsup.gelius.dao.entity;

import ua.skillsup.gelius.dao.entity.dictionary.Profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bigovki_deltas")
public class BigovkiDeltas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bigovki_deltas_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false, unique = true)
    private Profile profile;

    @Column(name = "delta_1", precision = 5, scale = 3)
    private Double delta1;

    @Column(name = "delta_2", precision = 5, scale = 3)
    private Double delta2;

    @Column(name = "delta_3", precision = 5, scale = 3)
    private Double delta3;

    public BigovkiDeltas() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Double getDelta1() {
        return delta1;
    }

    public void setDelta1(Double delta1) {
        this.delta1 = delta1;
    }

    public Double getDelta2() {
        return delta2;
    }

    public void setDelta2(Double delta2) {
        this.delta2 = delta2;
    }

    public Double getDelta3() {
        return delta3;
    }

    public void setDelta3(Double delta3) {
        this.delta3 = delta3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BigovkiDeltas that = (BigovkiDeltas) o;

        return profile.equals(that.profile);

    }

    @Override
    public int hashCode() {
        return profile.hashCode();
    }

    @Override
    public String toString() {
        return "BigovkiDeltas{" +
            "id=" + id +
            ", profile=" + profile +
            ", delta1=" + delta1 +
            ", delta2=" + delta2 +
            ", delta3=" + delta3 +
            '}';
    }
}
