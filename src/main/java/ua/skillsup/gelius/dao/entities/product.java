package ua.skillsup.gelius.dao.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "id")
    @Column(name = "CLIENTS_LIST")
    private List<Client> clients;
    @Column(name = "PRODUCTS_NAME")
    private String productsName;
    @Column(name = "PRODUCTS_TYPE")
    private String productsType;
    @Column(name = "INNER_LENGTH")
    private Integer innerLength;
    @Column(name = "INNER_WIDTH")
    private Integer innerWidth;
    @Column(name = "INNER_HEIGHT")
    private Integer innerHeight;
    @Column(name = "GRADE")
    private String grade;
    @Column(name = "PROFILE")
    private String profile;
    @Column(name = "COLOUR")
    private String colour;
    @Column(name = "PRINT")
    private String print;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public String getProductsName() {
        return productsName;
    }

    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }

    public String getProductsType() {
        return productsType;
    }

    public void setProductsType(String productsType) {
        this.productsType = productsType;
    }

    public Integer getInnerLength() {
        return innerLength;
    }

    public void setInnerLength(Integer innerLength) {
        this.innerLength = innerLength;
    }

    public Integer getInnerWidth() {
        return innerWidth;
    }

    public void setInnerWidth(Integer innerWidth) {
        this.innerWidth = innerWidth;
    }

    public Integer getInnerHeight() {
        return innerHeight;
    }

    public void setInnerHeight(Integer innerHeight) {
        this.innerHeight = innerHeight;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getPrint() {
        return print;
    }

    public void setPrint(String print) {
        this.print = print;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", clients=" + clients +
                ", productsName='" + productsName + '\'' +
                ", productsType='" + productsType + '\'' +
                ", innerLength=" + innerLength +
                ", innerWidth=" + innerWidth +
                ", innerHeight=" + innerHeight +
                ", grade='" + grade + '\'' +
                ", profile='" + profile + '\'' +
                ", colour='" + colour + '\'' +
                ", print='" + print + '\'' +
                '}';
    }
}
