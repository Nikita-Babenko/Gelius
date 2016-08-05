package ua.skillsup.gelius.dto;

import ua.skillsup.gelius.dao.entities.Client;
import ua.skillsup.gelius.dao.entities.Dictionaries.ProductType;

import java.util.Objects;

public class ProductDto {
    private Long id;
    private Client client;
    private String productsName;
    private ProductType productsType;
    private Integer innerLength;
    private Integer innerWidth;
    private Integer innerHeight;
    private Long cardboardBrandID;
    private Long profileID;
    private String colour;
    private String print;
    private Character activity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getProductsName() {
        return productsName;
    }

    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }

    public ProductType getProductsType() {
        return productsType;
    }

    public void setProductsType(ProductType productsType) {
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

    public Long getCardboardBrandID() {
        return cardboardBrandID;
    }

    public void setCardboardBrandID(Long cardboardBrandID) {
        this.cardboardBrandID = cardboardBrandID;
    }

    public Long getProfileID() {
        return profileID;
    }

    public void setProfileID(Long profileID) {
        this.profileID = profileID;
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
                Objects.equals(client, that.client) &&
                Objects.equals(productsName, that.productsName) &&
                Objects.equals(productsType, that.productsType) &&
                Objects.equals(innerLength, that.innerLength) &&
                Objects.equals(innerWidth, that.innerWidth) &&
                Objects.equals(innerHeight, that.innerHeight) &&
                Objects.equals(cardboardBrandID, that.cardboardBrandID) &&
                Objects.equals(profileID, that.profileID) &&
                Objects.equals(colour, that.colour) &&
                Objects.equals(print, that.print);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, productsName, productsType, innerLength, innerWidth, innerHeight,
                cardboardBrandID, profileID, colour, print);
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", client=" + client +
                ", productsName='" + productsName + '\'' +
                ", productsTypeID='" + productsType + '\'' +
                ", innerLength=" + innerLength +
                ", innerWidth=" + innerWidth +
                ", innerHeight=" + innerHeight +
                ", cardboardBrandID='" + cardboardBrandID + '\'' +
                ", profileID='" + profileID + '\'' +
                ", colour='" + colour + '\'' +
                ", print='" + print + '\'' +
                '}';
    }
}
