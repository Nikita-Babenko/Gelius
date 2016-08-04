package ua.skillsup.gelius.dao.entities;


import javax.persistence.*;
import javax.validation.constraints.Size;

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

    @OneToOne
    @JoinColumn(name = "PRODUCTS_TYPE_ID", table = "PRODUCT_TYPE")
    @Column(name = "PRODUCTS_TYPE_ID")
    private Long productsTypeID;

    @Column(name = "INNER_LENGTH")
    private Integer innerLength;

    @Column(name = "INNER_WIDTH")
    private Integer innerWidth;

    @Column(name = "INNER_HEIGHT")
    private Integer innerHeight;

    @Column(name = "CARDBOARD_BRAND_ID")
    private Long cardboardBrandID;

    @Column(name = "PROFILE_ID")
    private Long profileID;

    @Column(name = "CELLULOUSE_LAYER_ID")
    private Long cellulouseLayerID;

    @Column(name = "FACE_LAYER_ID")
    private Long faceLayerID;

    @Size(max = 30)
    @Column(name = "PRINT")
    private String print;

    @Column(name = "ACTIVITY")
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

    public Long getProductsTypeID() {
        return productsTypeID;
    }

    public void setProductsTypeID(Long productsTypeID) {
        this.productsTypeID = productsTypeID;
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

    public Long getCellulouseLayerID() {
        return cellulouseLayerID;
    }

    public void setCellulouseLayerID(Long cellulouseLayerID) {
        this.cellulouseLayerID = cellulouseLayerID;
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


}
