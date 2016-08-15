package ua.skillsup.gelius.model.dto;

import ua.skillsup.gelius.model.dto.dictionary.*;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;

public class ProductDto {

    // Звездочкой в комментарии помечены "сырые" поля, пришедшие от клиента.

    private Long id;
    private Integer productNumber;
    private Boolean isNew;

    //TODO валидация: дата должна быть сегодняшней или в прошлом
    private LocalDate productCreateDate;
    private String productCreateDateValue; // *

    //TODO валидация: дата должна быть сегодняшней?
    private LocalDate productUpdateDate;
    private String productUpdateDateValue; // *

    @Range(max = 50, message = "подготовил - не должно превышать {max} симв.")
    private String personPrepared;

    private Boolean isUse;
    private ClientDto client;
    private Long clientId; // *
    private String productName;
    private ProductTypeDto productType;
    private Long productTypeId; // *
    private Integer innerLength;
    private Integer innerWidth;
    private Integer innerHeight;
    private Double theoreticalSquare;
    private Double actualSquare;
    private FormatDto format;
    private Long formatId; // *
    private ProfileDto profile;
    private Long profileId; // *
    private CardBoardBrandDto cardboardBrand;
    private Long cardboardBrandId; // *
    private CelluloseLayerDto celluloseLayer;
    private Long celluloseLayerId; // *
    private FaceLayerDto faceLayer;
    private Long faceLayerId; // *
    private InnerLayerDto innerLayer;
    private Long innerLayerId; // *
    private String material;
    private Integer sizeWorkpieceLength;
    private Integer sizeWorkpieceWidth;

    @Min(value = 1, message = "количество с листа не может быть меньше {min} шт.")
    private Integer numberFromSheet;

    @NotNull(message = "формат заготовки должен быть заполнен")
    private Integer blankFormat;

    private ConnectionValveDto connectionValve;
    private Long connectionValveId; // *
    private String stamp;
    private String cliche;
    private PackingDto packing;
    private Long packingId; // *
    private Integer numberInPack;
    private Integer numberInTransportPackage;
    private Integer packageLength;
    private Integer packageWidth;
    private Integer packageHeight;
    private PalletDto pallet;
    private Long palletId; // *
    private PalletPlacementDto palletPlacement;
    private Long palletPlacementId; // *
    private Integer palletRows;
    private Integer numberLoadCar;
    private Integer productionFormat;

    public ProductDto() {
    }

    public ProductDto(Long id) {
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

    public FormatDto getFormat() {
        return format;
    }

    public void setFormat(FormatDto format) {
        this.format = format;
    }

    public ProfileDto getProfile() {
        return profile;
    }

    public void setProfile(ProfileDto profile) {
        this.profile = profile;
    }

    public CardBoardBrandDto getCardboardBrand() {
        return cardboardBrand;
    }

    public void setCardboardBrand(CardBoardBrandDto cardboardBrand) {
        this.cardboardBrand = cardboardBrand;
    }

    public CelluloseLayerDto getCelluloseLayer() {
        return celluloseLayer;
    }

    public void setCelluloseLayer(CelluloseLayerDto celluloseLayer) {
        this.celluloseLayer = celluloseLayer;
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

    public ConnectionValveDto getConnectionValve() {
        return connectionValve;
    }

    public void setConnectionValve(ConnectionValveDto connectionValve) {
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

    public PackingDto getPacking() {
        return packing;
    }

    public void setPacking(PackingDto packing) {
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

    public PalletDto getPallet() {
        return pallet;
    }

    public void setPallet(PalletDto pallet) {
        this.pallet = pallet;
    }

    public PalletPlacementDto getPalletPlacement() {
        return palletPlacement;
    }

    public void setPalletPlacement(PalletPlacementDto palletPlacement) {
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

    public String getProductCreateDateValue() {
        return productCreateDateValue;
    }

    public void setProductCreateDateValue(String productCreateDateValue) {
        this.productCreateDateValue = productCreateDateValue;
    }

    public String getProductUpdateDateValue() {
        return productUpdateDateValue;
    }

    public void setProductUpdateDateValue(String productUpdateDateValue) {
        this.productUpdateDateValue = productUpdateDateValue;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Long getFormatId() {
        return formatId;
    }

    public void setFormatId(Long formatId) {
        this.formatId = formatId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getCardboardBrandId() {
        return cardboardBrandId;
    }

    public void setCardboardBrandId(Long cardboardBrandId) {
        this.cardboardBrandId = cardboardBrandId;
    }

    public Long getCelluloseLayerId() {
        return celluloseLayerId;
    }

    public void setCelluloseLayerId(Long celluloseLayerId) {
        this.celluloseLayerId = celluloseLayerId;
    }

    public Long getFaceLayerId() {
        return faceLayerId;
    }

    public void setFaceLayerId(Long faceLayerId) {
        this.faceLayerId = faceLayerId;
    }

    public Long getInnerLayerId() {
        return innerLayerId;
    }

    public void setInnerLayerId(Long innerLayerId) {
        this.innerLayerId = innerLayerId;
    }

    public Long getConnectionValveId() {
        return connectionValveId;
    }

    public void setConnectionValveId(Long connectionValveId) {
        this.connectionValveId = connectionValveId;
    }

    public Long getPackingId() {
        return packingId;
    }

    public void setPackingId(Long packingId) {
        this.packingId = packingId;
    }

    public Long getPalletId() {
        return palletId;
    }

    public void setPalletId(Long palletId) {
        this.palletId = palletId;
    }

    public Long getPalletPlacementId() {
        return palletPlacementId;
    }

    public void setPalletPlacementId(Long palletPlacementId) {
        this.palletPlacementId = palletPlacementId;
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
