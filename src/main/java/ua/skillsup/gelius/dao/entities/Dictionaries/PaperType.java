package ua.skillsup.gelius.dao.entities.Dictionaries;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity       //  Тип картона
@Table(name = "PAPER_TYPE")
public class PaperType {

    @Id
    @Column(name = "PAPER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 50)
    @Column(name = "PAPER_TYPE")
    private String paperType;

    public PaperType(String paperType) {
        this.paperType = paperType;
    }

    public PaperType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setBrand(String paperType) {
        this.paperType = paperType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaperType)) return false;
        PaperType that = (PaperType) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getPaperType(), that.getPaperType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPaperType());
    }

    @Override
    public String toString() {
        return "PaperType{" +
                "id=" + id +
                ", paperType='" + paperType + '\'' +
                '}';
    }
}