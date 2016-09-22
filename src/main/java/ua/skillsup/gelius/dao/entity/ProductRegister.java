package ua.skillsup.gelius.dao.entity;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Formula;
import ua.skillsup.gelius.dao.entity.dictionary.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "product")
public class ProductRegister {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_number")
    private Integer productNumber;

    @Column(name = "isNew")
    private Boolean isNew;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "client_id")
    private Client client;

    @Size(max = 200)
    @Column(name = "product_name")
    private String productName;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @Column(name = "inner_length")
    private Integer innerLength;

    @Column(name = "inner_width")
    private Integer innerWidth;

    @Column(name = "inner_height")
    private Integer innerHeight;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "cardboard_brand_id")
    private CardboardBrand cardboardBrand;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "face_layer_id")
    private FaceLayer faceLayer;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "inner_layer_id")
    private InnerLayer innerLayer;

    @Formula(value = "concat(coalesce((select f.face_layer from face_layer f where f.face_layer_id = face_layer_id), '-'), " +
            "'/', coalesce((select i.inner_layer from inner_layer i where i.inner_layer_id = inner_layer_id), '-'))")
    private String layersColours;

    @Size(max = 50)
    @Column(name = "cliche")
    private String cliche;

    public ProductRegister() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean aNew) {
        isNew = aNew;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
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

    public FaceLayer getFaceLayer() {
        return faceLayer;
    }

    public void setFaceLayer(FaceLayer faceLayer) {
        this.faceLayer = faceLayer;
    }

    public InnerLayer getInnerLayer() {
        return innerLayer;
    }

    public void setInnerLayer(InnerLayer innerLayer) {
        this.innerLayer = innerLayer;
    }

    public String getLayersColours() {
        return layersColours;
    }

    public void setLayersColours(String layersColours) {
        this.layersColours = layersColours;
    }

    public String getCliche() {
        return cliche;
    }

    public void setCliche(String cliche) {
        this.cliche = cliche;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRegister that = (ProductRegister) o;
        return Objects.equals(productNumber, that.productNumber) &&
                Objects.equals(isNew, that.isNew) &&
                Objects.equals(client, that.client) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productType, that.productType) &&
                Objects.equals(innerLength, that.innerLength) &&
                Objects.equals(innerWidth, that.innerWidth) &&
                Objects.equals(innerHeight, that.innerHeight) &&
                Objects.equals(cardboardBrand, that.cardboardBrand) &&
                Objects.equals(profile, that.profile) &&
                Objects.equals(faceLayer, that.faceLayer) &&
                Objects.equals(innerLayer, that.innerLayer) &&
                Objects.equals(layersColours, that.layersColours) &&
                Objects.equals(cliche, that.cliche);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNumber, isNew, client, productName, productType, innerLength, innerWidth, innerHeight, cardboardBrand, profile, faceLayer, innerLayer, layersColours, cliche);
    }

    @Override
    public String toString() {
        return "ProductRegister{" + "id=" + id +
                ", productNumber=" + productNumber +
                ", isNew=" + isNew +
                ", client=" + client +
                ", productName='" + productName + '\'' +
                ", productType=" + productType +
                ", innerLength=" + innerLength +
                ", innerWidth=" + innerWidth +
                ", innerHeight=" + innerHeight +
                ", cardboardBrand=" + cardboardBrand +
                ", profile=" + profile +
                ", faceLayer=" + faceLayer +
                ", innerLayer=" + innerLayer +
                ", cliche='" + cliche + '\'' +
                '}' +
                '\n';
    }
}
