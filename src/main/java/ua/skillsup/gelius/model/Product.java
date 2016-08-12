package ua.skillsup.gelius.model;


import ua.skillsup.gelius.model.dictionary.CardboardBrand;
import ua.skillsup.gelius.model.dictionary.ProductType;
import ua.skillsup.gelius.model.dictionary.Profile;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CLIENTS_ID")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "CARDBOARD_BRAND_ID")
    private CardboardBrand cardboardBrand;

    @ManyToOne
    @JoinColumn(name = "PROFILE_ID")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "PRODUCTS_TYPE_ID")
    private ProductType productsType;

    @Size(max = 200)
    @Column(name = "PRODUCTS_NAME")
    private String productsName;

    @Column(name = "INNER_LENGTH")
    private Integer innerLength;

    @Column(name = "INNER_WIDTH")
    private Integer innerWidth;

    @Column(name = "INNER_HEIGHT")
    private Integer innerHeight;

    @Column(name = "COLOUR")
    private String colour;

    @Size(max = 30)
    @Column(name = "PRINT")
    private String print;

    @Column(name = "ACTIVITY")
    private Character activity;

    public Product() {
    }

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


    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId()) &&
                Objects.equals(getClient(), product.getClient()) &&
                Objects.equals(getProductsName(), product.getProductsName()) &&
                Objects.equals(getProductsType(), product.getProductsType()) &&
                Objects.equals(getInnerLength(), product.getInnerLength()) &&
                Objects.equals(getInnerWidth(), product.getInnerWidth()) &&
                Objects.equals(getInnerHeight(), product.getInnerHeight()) &&
                Objects.equals(getCardboardBrand(), product.getCardboardBrand()) &&
                Objects.equals(getProfile(), product.getProfile()) &&
                Objects.equals(getColour(), product.getColour()) &&
                Objects.equals(getPrint(), product.getPrint()) &&
                Objects.equals(getActivity(), product.getActivity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClient(), getProductsName(), getProductsType(), getInnerLength(),
                getInnerWidth(), getInnerHeight(), getCardboardBrand(), getProfile(), getColour(), getPrint(), getActivity());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", client=" + client +
                ", cardboardBrand=" + cardboardBrand +
                ", profile=" + profile +
                ", productsType=" + productsType +
                ", productsName='" + productsName + '\'' +
                ", innerLength=" + innerLength +
                ", innerWidth=" + innerWidth +
                ", innerHeight=" + innerHeight +
                ", colour='" + colour + '\'' +
                ", print='" + print + '\'' +
                ", activity=" + activity +
                '}';
    }
}
