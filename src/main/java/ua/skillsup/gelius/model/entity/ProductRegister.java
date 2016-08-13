package ua.skillsup.gelius.model.entity;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ua.skillsup.gelius.model.entity.dictionary.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
public class ProductRegister {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "client")
    private Client client;

    @Size(max = 200)
    @Column(name = "product_name")
    private String productName;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "product_type")
    private ProductType productType;

    @Column(name = "inner_length")
    private Integer innerLength;

    @Column(name = "inner_width")
    private Integer innerWidth;

    @Column(name = "inner_height")
    private Integer innerHeight;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "cardboard_brand")
    private CardboardBrand cardboardBrand;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "profile")
    private Profile profile;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "face_layer")
    private FaceLayer faceLayer;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "inner_layer")
    private InnerLayer innerLayer;

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
        sb.append('\n');
        return sb.toString();
    }
}
