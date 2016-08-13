package ua.skillsup.gelius.model.entity;


import ua.skillsup.gelius.model.entity.dictionary.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PRODUCT")
public class ProductRegister {
    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CLIENT")
    private Client client;

    @Size(max = 200)
    @Column(name = "PRODUCT_NAME")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_TYPE")
    private ProductType productType;

    @Column(name = "INNER_LENGTH")
    private Integer innerLength;

    @Column(name = "INNER_WIDTH")
    private Integer innerWidth;

    @Column(name = "INNER_HEIGHT")
    private Integer innerHeight;

    @ManyToOne
    @JoinColumn(name = "CARDBOARD_BRAND")
    private CardboardBrand cardboardBrand;

    @ManyToOne
    @JoinColumn(name = "PROFILE")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "FACE_LAYER")
    private FaceLayer faceLayer;

    @ManyToOne
    @JoinColumn(name = "INNER_LAYER")
    private InnerLayer innerLayer;

    @Size(max = 50)
    @Column(name = "CLICHE")
    private String cliche;

    public ProductRegister() {
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

    public String getCliche() {
        return cliche;
    }

    public void setCliche(String cliche) {
        this.cliche = cliche;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductRegister{");
        sb.append("id=").append(id);
        sb.append(", client=").append(client);
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", productType=").append(productType);
        sb.append(", innerLength=").append(innerLength);
        sb.append(", innerWidth=").append(innerWidth);
        sb.append(", innerHeight=").append(innerHeight);
        sb.append(", cardboardBrand=").append(cardboardBrand);
        sb.append(", profile=").append(profile);
        sb.append(", faceLayer=").append(faceLayer);
        sb.append(", innerLayer=").append(innerLayer);
        sb.append(", cliche='").append(cliche).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
