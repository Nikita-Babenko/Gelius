package ua.skillsup.gelius.model.dto;

import ua.skillsup.gelius.model.entity.dictionary.*;

import java.time.LocalDate;

public class ProductDto {

    private Long id;
    private Integer productNumber;
    private Boolean isNew;
    private LocalDate productCreateDate;
    private LocalDate productUpdateDate;
    private String personPrepared;
    private Boolean isUse;
    private Client client;
    private String productName;
    private ProductType productType;
    private Integer innerLength;
    private Integer innerWidth;
    private Integer innerHeight;
    private Double theoreticalSquare;
    private Double actualSquare;
    private Format format;
    private Profile profile;
    private CardboardBrand cardboardBrand;
    private CardboardBrand celluloseLayer;
    private FaceLayer faceLayer;
    private InnerLayer innerLayer;
    private String material;
    private Integer sizeWorkpieceLength;
    private Integer sizeWorkpieceWidth;
    private Integer numberFromSheet;
    private Integer blankFormat;
    private ConnectionValve connectionValve;
    private String stamp;
    private String cliche;
    private Packing packing;
    private Integer numberInPack;
    private Integer numberInTransportPackage;
    private Integer packageLength;
    private Integer packageWidth;
    private Integer packageHeight;
    private Pallet pallet;
    private PalletPlacement palletPlacement;
    private Integer palletRows;
    private Integer numberLoadCar;
    private Integer productionFormat;

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

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public LocalDate getProductCreateDate() {
        return productCreateDate;
    }

    public void setProductCreateDate(LocalDate productCreateDate) {
        this.productCreateDate = productCreateDate;
    }

    public LocalDate getProductUpdateDate() {
        return productUpdateDate;
    }

    public void setProductUpdateDate(LocalDate productUpdateDate) {
        this.productUpdateDate = productUpdateDate;
    }

    public String getPersonPrepared() {
        return personPrepared;
    }

    public void setPersonPrepared(String personPrepared) {
        this.personPrepared = personPrepared;
    }

    public Boolean getUse() {
        return isUse;
    }

    public void setUse(Boolean use) {
        isUse = use;
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

    public Double getTheoreticalSquare() {
        return theoreticalSquare;
    }

    public void setTheoreticalSquare(Double theoreticalSquare) {
        this.theoreticalSquare = theoreticalSquare;
    }

    public Double getActualSquare() {
        return actualSquare;
    }

    public void setActualSquare(Double actualSquare) {
        this.actualSquare = actualSquare;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public CardboardBrand getCardboardBrand() {
        return cardboardBrand;
    }

    public void setCardboardBrand(CardboardBrand cardboardBrand) {
        this.cardboardBrand = cardboardBrand;
    }

    public CardboardBrand getCelluloseLayer() {
        return celluloseLayer;
    }

    public void setCelluloseLayer(CardboardBrand celluloseLayer) {
        this.celluloseLayer = celluloseLayer;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getSizeWorkpieceLength() {
        return sizeWorkpieceLength;
    }

    public void setSizeWorkpieceLength(Integer sizeWorkpieceLength) {
        this.sizeWorkpieceLength = sizeWorkpieceLength;
    }

    public Integer getSizeWorkpieceWidth() {
        return sizeWorkpieceWidth;
    }

    public void setSizeWorkpieceWidth(Integer sizeWorkpieceWidth) {
        this.sizeWorkpieceWidth = sizeWorkpieceWidth;
    }

    public Integer getNumberFromSheet() {
        return numberFromSheet;
    }

    public void setNumberFromSheet(Integer numberFromSheet) {
        this.numberFromSheet = numberFromSheet;
    }

    public Integer getBlankFormat() {
        return blankFormat;
    }

    public void setBlankFormat(Integer blankFormat) {
        this.blankFormat = blankFormat;
    }

    public ConnectionValve getConnectionValve() {
        return connectionValve;
    }

    public void setConnectionValve(ConnectionValve connectionValve) {
        this.connectionValve = connectionValve;
    }

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    public String getCliche() {
        return cliche;
    }

    public void setCliche(String cliche) {
        this.cliche = cliche;
    }

    public Packing getPacking() {
        return packing;
    }

    public void setPacking(Packing packing) {
        this.packing = packing;
    }

    public Integer getNumberInPack() {
        return numberInPack;
    }

    public void setNumberInPack(Integer numberInPack) {
        this.numberInPack = numberInPack;
    }

    public Integer getNumberInTransportPackage() {
        return numberInTransportPackage;
    }

    public void setNumberInTransportPackage(Integer numberInTransportPackage) {
        this.numberInTransportPackage = numberInTransportPackage;
    }

    public Integer getPackageLength() {
        return packageLength;
    }

    public void setPackageLength(Integer packageLength) {
        this.packageLength = packageLength;
    }

    public Integer getPackageWidth() {
        return packageWidth;
    }

    public void setPackageWidth(Integer packageWidth) {
        this.packageWidth = packageWidth;
    }

    public Integer getPackageHeight() {
        return packageHeight;
    }

    public void setPackageHeight(Integer packageHeight) {
        this.packageHeight = packageHeight;
    }

    public Pallet getPallet() {
        return pallet;
    }

    public void setPallet(Pallet pallet) {
        this.pallet = pallet;
    }

    public PalletPlacement getPalletPlacement() {
        return palletPlacement;
    }

    public void setPalletPlacement(PalletPlacement palletPlacement) {
        this.palletPlacement = palletPlacement;
    }

    public Integer getPalletRows() {
        return palletRows;
    }

    public void setPalletRows(Integer palletRows) {
        this.palletRows = palletRows;
    }

    public Integer getNumberLoadCar() {
        return numberLoadCar;
    }

    public void setNumberLoadCar(Integer numberLoadCar) {
        this.numberLoadCar = numberLoadCar;
    }

    public Integer getProductionFormat() {
        return productionFormat;
    }

    public void setProductionFormat(Integer productionFormat) {
        this.productionFormat = productionFormat;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductDto{");
        sb.append("id=").append(id);
        sb.append(", productNumber=").append(productNumber);
        sb.append(", isNew=").append(isNew);
        sb.append(", productCreateDate=").append(productCreateDate);
        sb.append(", productUpdateDate=").append(productUpdateDate);
        sb.append(", personPrepared='").append(personPrepared).append('\'');
        sb.append(", isUse=").append(isUse);
        sb.append(", client=").append(client);
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", productType=").append(productType);
        sb.append(", innerLength=").append(innerLength);
        sb.append(", innerWidth=").append(innerWidth);
        sb.append(", innerHeight=").append(innerHeight);
        sb.append(", theoreticalSquare=").append(theoreticalSquare);
        sb.append(", actualSquare=").append(actualSquare);
        sb.append(", format=").append(format);
        sb.append(", profile=").append(profile);
        sb.append(", cardboardBrand=").append(cardboardBrand);
        sb.append(", celluloseLayer=").append(celluloseLayer);
        sb.append(", faceLayer=").append(faceLayer);
        sb.append(", innerLayer=").append(innerLayer);
        sb.append(", material='").append(material).append('\'');
        sb.append(", sizeWorkpieceLength=").append(sizeWorkpieceLength);
        sb.append(", sizeWorkpieceWidth=").append(sizeWorkpieceWidth);
        sb.append(", numberFromSheet=").append(numberFromSheet);
        sb.append(", blankFormat=").append(blankFormat);
        sb.append(", connectionValve=").append(connectionValve);
        sb.append(", stamp='").append(stamp).append('\'');
        sb.append(", cliche='").append(cliche).append('\'');
        sb.append(", packing=").append(packing);
        sb.append(", numberInPack=").append(numberInPack);
        sb.append(", numberInTransportPackage=").append(numberInTransportPackage);
        sb.append(", packageLength=").append(packageLength);
        sb.append(", packageWidth=").append(packageWidth);
        sb.append(", packageHeight=").append(packageHeight);
        sb.append(", pallet=").append(pallet);
        sb.append(", palletPlacement=").append(palletPlacement);
        sb.append(", palletRows=").append(palletRows);
        sb.append(", numberLoadCar=").append(numberLoadCar);
        sb.append(", productionFormat=").append(productionFormat);
        sb.append('}');
        sb.append('\n');
        return sb.toString();
    }
}
