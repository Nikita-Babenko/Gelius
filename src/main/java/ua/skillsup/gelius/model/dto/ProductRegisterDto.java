package ua.skillsup.gelius.model.dto;

import ua.skillsup.gelius.model.dto.dictionary.*;

public class ProductRegisterDto {

    private Long id;

    private ClientDto client;

    private String productName;

    private ProductTypeDto productType;

    private Integer innerLength;

    private Integer innerWidth;

    private Integer innerHeight;

    private CardBoardBrandDto cardboardBrand;

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

    public CardBoardBrandDto getCardboardBrand() {
        return cardboardBrand;
    }

    public void setCardboardBrand(CardBoardBrandDto cardboardBrand) {
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
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductRegisterDto{");
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
