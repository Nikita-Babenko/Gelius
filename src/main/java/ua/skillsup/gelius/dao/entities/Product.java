package ua.skillsup.gelius.dao.entities;


import ua.skillsup.gelius.dao.entities.Dictionaries.ProductType;

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

    @Size(max = 200)
    @Column(name = "PRODUCTS_NAME")
    private String productsName;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_TYPE_ID")
    private ProductType productsType;

    @Column(name = "INNER_LENGTH")
    private Integer innerLength;

    @Column(name = "INNER_WIDTH")
    private Integer innerWidth;

    @Column(name = "INNER_HEIGHT")
    private Integer innerHeight;

    @Column(name = "CARDBOARD_BRAND")
    private Long cardboardBrandID;

    @Column(name = "PROFILE_ID")
    private Long profileID;

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

    public Long getCardboardBrandID() {
        return cardboardBrandID;
    }

    public void setCardboardBrandID(Long cardboardBrandID) {
        this.cardboardBrandID = cardboardBrandID;
    }


    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Long getProfileID() {
        return profileID;
    }

    public void setProfileID(Long profileID) {
        this.profileID = profileID;
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
                Objects.equals(getCardboardBrandID(), product.getCardboardBrandID()) &&
                Objects.equals(getProfileID(), product.getProfileID()) &&
                Objects.equals(getColour(), product.getColour()) &&
                Objects.equals(getPrint(), product.getPrint()) &&
                Objects.equals(getActivity(), product.getActivity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClient(), getProductsName(), getProductsType(), getInnerLength(),
                getInnerWidth(), getInnerHeight(), getCardboardBrandID(), getProfileID(), getColour(), getPrint(), getActivity());
    }


    @Override
    public String toString() {
        return "Product{" +
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
                ", activity=" + activity +
                '}';
    }
}
