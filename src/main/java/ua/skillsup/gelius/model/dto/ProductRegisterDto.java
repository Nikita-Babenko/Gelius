package ua.skillsup.gelius.model.dto;

import ua.skillsup.gelius.model.dto.dictionary.*;

import java.util.Objects;

public class ProductRegisterDto {

    private Long id;

    private Integer productNumber;

    private Boolean isNew;

    private ClientDto client;

    private String productName;

    private ProductTypeDto productType;

    private Integer innerLength;

    private Integer innerWidth;

    private Integer innerHeight;

    private CardboardBrandDto cardboardBrand;

    private ProfileDto profile;

    private FaceLayerDto faceLayer;

    private InnerLayerDto innerLayer;

    private String layersColours;

    private String cliche;

    public ProductRegisterDto() {
    }

    public ProductRegisterDto(Long id) {
        this.id = id;
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

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductTypeDto getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeDto productType) {
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

    public CardboardBrandDto getCardboardBrand() {
        return cardboardBrand;
    }

    public void setCardboardBrand(CardboardBrandDto cardboardBrand) {
        this.cardboardBrand = cardboardBrand;
    }

    public ProfileDto getProfile() {
        return profile;
    }

    public void setProfile(ProfileDto profile) {
        this.profile = profile;
    }

    public FaceLayerDto getFaceLayer() {
        return faceLayer;
    }

    public void setFaceLayer(FaceLayerDto faceLayer) {
        this.faceLayer = faceLayer;
    }

    public InnerLayerDto getInnerLayer() {
        return innerLayer;
    }

    public void setInnerLayer(InnerLayerDto innerLayer) {
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
        ProductRegisterDto that = (ProductRegisterDto) o;
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
        return "ProductRegisterDto{" + "id=" + id +
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
                '}';
    }
}
