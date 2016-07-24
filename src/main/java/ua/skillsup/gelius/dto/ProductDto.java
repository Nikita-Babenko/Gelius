package ua.skillsup.gelius.dto;

import ua.skillsup.gelius.model.entities.Client;

import java.util.Objects;

public class ProductDto {
    private Long id;
    private Client clients;
    private String productsName;
    private String productsType;
    private Integer innerLength;
    private Integer innerWidth;
    private Integer innerHeight;
    private String grade;
    private String profile;
    private String colour;
    private String print;
    private Character activity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClients() {
        return clients;
    }

    public void setClient(Client clients) {
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

    public Character getActivity() {
        return activity;
    }

    public void setActivity(Character activity) {
        this.activity = activity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(clients, that.clients) &&
                Objects.equals(productsName, that.productsName) &&
                Objects.equals(productsType, that.productsType) &&
                Objects.equals(innerLength, that.innerLength) &&
                Objects.equals(innerWidth, that.innerWidth) &&
                Objects.equals(innerHeight, that.innerHeight) &&
                Objects.equals(grade, that.grade) &&
                Objects.equals(profile, that.profile) &&
                Objects.equals(colour, that.colour) &&
                Objects.equals(print, that.print);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clients, productsName, productsType, innerLength, innerWidth, innerHeight, grade, profile, colour, print);
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", client=" + clients +
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
