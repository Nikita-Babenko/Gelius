package ua.skillsup.gelius.model.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ua.skillsup.gelius.annotation.CheckDoubleAboveZero;
import ua.skillsup.gelius.annotation.CheckOldProductNumberExistence;
import ua.skillsup.gelius.model.dto.dictionary.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@CheckOldProductNumberExistence(message = "не заполнен номер техкарты")
public class ProductDto {

    private Long id;
    private Integer productNumber;
    private Boolean isNew;

    private LocalDate productCreateDate;
    private LocalDate productUpdateDate;

    @Size(max = 50, message = "подготовил - не должно превышать {max} символов")
    private String personPrepared;

    private Boolean isUse;
    private ClientDto client;

    @Size(max = 200, message = "название продукта не может превышать {max} символов")
    private String productName;

    private ProductTypeDto productType;

    @Min(value = 1, message = "внутренняя длина не может быть меньше {value}")
    private Integer innerLength;

    @Min(value = 1, message = "внутренняя ширина не может быть меньше {value}")
    private Integer innerWidth;

    @Min(value = 1, message = "внутренняя высота не может быть меньше {value}")
    private Integer innerHeight;

    @CheckDoubleAboveZero(message = "теоретическая площадь должна быть больше нуля")
    private Double theoreticalSquare;

    @CheckDoubleAboveZero(message = "фактическая площадь должна быть больше нуля")
    private Double actualSquare;

    private FormatDto format;
    private ProfileDto profile;
    private CardboardBrandDto cardboardBrand;
    private CelluloseLayerDto celluloseLayer;
    private FaceLayerDto faceLayer;
    private InnerLayerDto innerLayer;

    @Size(max = 200, message = "материал не может превышать {max} символов")
    private String material;

    @Min(value = 1, message = "длина (размер заготовки) не может быть меньше {value}")
    private Integer sizeWorkpieceLength;

    @Min(value = 1, message = "ширина (размер заготовки) не может быть меньше {value}")
    private Integer sizeWorkpieceWidth;

    @Min(value = 1, message = "количество с листа не может быть меньше {value} шт.")
    private Integer numberFromSheet;

    @NotNull(message = "формат заготовки должен быть заполнен")
    @Min(value = 1, message = "формат заготовки не может быть меньше {value}")
    private Integer blankFormat;

    private ConnectionValveDto connectionValve;

    @Size(max = 50, message = "штамп не может превышать {max} символов")
    private String stamp;

    @Size(max = 50, message = "клише не может превышать {max} символов")
    private String cliche;

    private PackingDto packing;

    @Min(value = 1, message = "количество в пачке не может быть меньше {value} шт.")
    private Integer numberInPack;

    @Min(value = 1, message = "количество в транспортном пакете не может быть меньше {value} шт.")
    private Integer numberInTransportPackage;

    @Min(value = 1, message = "длина (размеры пакета) не может быть меньше {value}")
    private Integer packageLength;

    @Min(value = 1, message = "ширина (размеры пакета) не может быть меньше {value}")
    private Integer packageWidth;

    @Min(value = 1, message = "высота (размеры пакета) не может быть меньше {value}")
    private Integer packageHeight;

    private PalletDto pallet;
    private PalletPlacementDto palletPlacement;

    @Min(value = 1, message = "количество рядов на поддоне не может быть меньше {value} шт.")
    private Integer palletRows;

    @Min(value = 1, message = "загрузка автомобиля не может быть меньше {value} шт.")
    private Integer numberLoadCar;

    @Min(value = 1, message = "производственный формат не может быть меньше {value}")
    private Integer productionFormat;

    @JsonManagedReference
    @Valid
    private List<WorkabilityNotesDto> workabilityNotes;


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

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean aNew) {
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

    public Boolean getIsUse() {
        return isUse;
    }

    public void setIsUse(Boolean use) {
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

    public CardboardBrandDto getCardboardBrand() {
        return cardboardBrand;
    }

    public void setCardboardBrand(CardboardBrandDto cardboardBrand) {
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

    public List<WorkabilityNotesDto> getWorkabilityNotes() {
        return workabilityNotes;
    }

    public void setWorkabilityNotes(List<WorkabilityNotesDto> workabilityNotes) {
        this.workabilityNotes = workabilityNotes;
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
        sb.append(", workabilityNotes=").append(workabilityNotes);
        sb.append('}');
        return sb.toString();
    }
}
