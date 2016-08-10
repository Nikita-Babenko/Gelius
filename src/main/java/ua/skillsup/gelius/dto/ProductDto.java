package ua.skillsup.gelius.dto;

import ua.skillsup.gelius.dao.entities.Client;
import ua.skillsup.gelius.dao.entities.Dictionaries.CardboardBrand;
import ua.skillsup.gelius.dao.entities.Dictionaries.ProductType;
import ua.skillsup.gelius.dao.entities.Dictionaries.Profile;

import java.util.Objects;

public class ProductDto {
    private Long id;
    private Client client;
    private ProductType productsType;
    private CardboardBrand cardboardBrand;
    private String productsName;
    private Integer innerLength;
    private Integer innerWidth;
    private Integer innerHeight;
    private Profile profile;
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

    public CardboardBrand getCardboardBrand() {
        return cardboardBrand;
    }

    public void setCardboardBrand(CardboardBrand cardboardBrand) {
        this.cardboardBrand = cardboardBrand;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
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
                Objects.equals(client, that.client) &&
                Objects.equals(productsName, that.productsName) &&
                Objects.equals(productsType, that.productsType) &&
                Objects.equals(innerLength, that.innerLength) &&
                Objects.equals(innerWidth, that.innerWidth) &&
                Objects.equals(innerHeight, that.innerHeight) &&
                Objects.equals(cardboardBrand, that.cardboardBrand) &&
                Objects.equals(profile, that.profile) &&
                Objects.equals(colour, that.colour) &&
                Objects.equals(print, that.print);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, productsName, productsType, innerLength, innerWidth, innerHeight,
                cardboardBrand, profile, colour, print);
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", client=" + client +
                ", productsType=" + productsType +
                ", cardboardBrand=" + cardboardBrand +
                ", productsName='" + productsName + '\'' +
                ", innerLength=" + innerLength +
                ", innerWidth=" + innerWidth +
                ", innerHeight=" + innerHeight +
                ", profile=" + profile +
                ", colour='" + colour + '\'' +
                ", print='" + print + '\'' +
                ", activity=" + activity +
                '}';
    }
}
