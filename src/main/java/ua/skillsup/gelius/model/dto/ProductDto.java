package ua.skillsup.gelius.model.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ua.skillsup.gelius.annotation.CheckDoubleAboveZero;
import ua.skillsup.gelius.annotation.CheckOldProductNumberExistence;
import ua.skillsup.gelius.model.dto.dictionary.CardboardBrandDto;
import ua.skillsup.gelius.model.dto.dictionary.CelluloseLayerDto;
import ua.skillsup.gelius.model.dto.dictionary.ClientDto;
import ua.skillsup.gelius.model.dto.dictionary.ConnectionValveDto;
import ua.skillsup.gelius.model.dto.dictionary.FaceLayerDto;
import ua.skillsup.gelius.model.dto.dictionary.FormatDto;
import ua.skillsup.gelius.model.dto.dictionary.InnerLayerDto;
import ua.skillsup.gelius.model.dto.dictionary.PackingDto;
import ua.skillsup.gelius.model.dto.dictionary.PalletDto;
import ua.skillsup.gelius.model.dto.dictionary.PalletPlacementDto;
import ua.skillsup.gelius.model.dto.dictionary.ProductTypeDto;
import ua.skillsup.gelius.model.dto.dictionary.ProfileDto;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @Size(max = 200, message = "особые условия не могут превышать {max} символов")
    private String specialConditions;

    @Min(value = 1, message = "длина (размер заготовки) не может быть меньше {value}")
    private Integer sizeWorkpieceLength;

    @CheckDoubleAboveZero(message = "ширина (размер заготовки) должна быть больше нуля")
    private Double sizeWorkpieceWidth;

    @Min(value = 1, message = "количество с листа не может быть меньше {value} шт.")
    private Integer numberFromSheet;

    @NotNull(message = "формат заготовки должен быть выбран")
    @CheckDoubleAboveZero(message = "формат заготовки должен быть больше нуля")
    private Double blankFormat;

    private ConnectionValveDto connectionValve;

    @Size(max = 100, message = "штамп не может превышать {max} символов")
    private String stamp;

    @Size(max = 100, message = "клише не может превышать {max} символов")
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

    @Min(value = 1, message = "количество заготовок на формате не может быть меньше {value}")
    private Integer numberBlanksOnFormat;

    @JsonManagedReference
    @Valid
    private List<ProducibilityNotesDto> producibilityNotes;

    @JsonManagedReference
    @Valid
    private List<BigovkiDto> bigovki;

    @JsonManagedReference
    @Valid
    private List<PerforationDto> perforations;

    @JsonManagedReference
    @Valid
    private List<PrintDto> prints;

    private Map<String, String> mapFilePathNames;

    private List<String> filePaths;

    private Map<String, String> mapImagePathNames;

    private List<String> fileImagePaths;

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

    public Double getSizeWorkpieceWidth() {
        return sizeWorkpieceWidth;
    }

    public void setSizeWorkpieceWidth(Double sizeWorkpieceWidth) {
        this.sizeWorkpieceWidth = sizeWorkpieceWidth;
    }

    public Integer getNumberFromSheet() {
        return numberFromSheet;
    }

    public void setNumberFromSheet(Integer numberFromSheet) {
        this.numberFromSheet = numberFromSheet;
    }

    public Double getBlankFormat() {
        return blankFormat;
    }

    public void setBlankFormat(Double blankFormat) {
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

    public List<ProducibilityNotesDto> getProducibilityNotes() {
        return producibilityNotes;
    }

    public void setProducibilityNotes(List<ProducibilityNotesDto> producibilityNotes) {
        this.producibilityNotes = producibilityNotes;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public Boolean getUse() {
        return isUse;
    }

    public void setUse(Boolean use) {
        isUse = use;
    }

    public String getSpecialConditions() {
        return specialConditions;
    }

    public void setSpecialConditions(String specialConditions) {
        this.specialConditions = specialConditions;
    }

    public Integer getNumberBlanksOnFormat() {
        return numberBlanksOnFormat;
    }

    public void setNumberBlanksOnFormat(Integer numberBlanksOnFormat) {
        this.numberBlanksOnFormat = numberBlanksOnFormat;
    }

    public List<BigovkiDto> getBigovki() {
        return bigovki;
    }

    public void setBigovki(List<BigovkiDto> bigovki) {
        this.bigovki = bigovki;
    }

    public List<PerforationDto> getPerforations() {
        return perforations;
    }

    public void setPerforations(List<PerforationDto> perforations) {
        this.perforations = perforations;
    }

    public List<PrintDto> getPrints() {
        return prints;
    }

    public void setPrints(List<PrintDto> prints) {
        this.prints = prints;
    }

    public List<String> getFilePaths() {
        return filePaths;
    }

    public void setFilePaths(List<String> filePaths) {
        this.filePaths = filePaths;
    }

    public List<String> getFileImagePaths() {
        return fileImagePaths;
    }

    public void setFileImagePaths(List<String> fileImagePaths) {
        this.fileImagePaths = fileImagePaths;
    }

    public Map<String, String> getMapFilePathNames() {
        return mapFilePathNames;
    }

    public void setMapFilePathNames(Map<String, String> mapFilePathNames) {
        this.mapFilePathNames = mapFilePathNames;
    }

    public Map<String, String> getMapImagePathNames() {
        return mapImagePathNames;
    }

    public void setMapImagePathNames(Map<String, String> mapImagePathNames) {
        this.mapImagePathNames = mapImagePathNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(productNumber, that.productNumber) &&
                Objects.equals(isNew, that.isNew) &&
                Objects.equals(productCreateDate, that.productCreateDate) &&
                Objects.equals(productUpdateDate, that.productUpdateDate) &&
                Objects.equals(personPrepared, that.personPrepared) &&
                Objects.equals(isUse, that.isUse) &&
                Objects.equals(client, that.client) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productType, that.productType) &&
                Objects.equals(innerLength, that.innerLength) &&
                Objects.equals(innerWidth, that.innerWidth) &&
                Objects.equals(innerHeight, that.innerHeight) &&
                Objects.equals(theoreticalSquare, that.theoreticalSquare) &&
                Objects.equals(actualSquare, that.actualSquare) &&
                Objects.equals(format, that.format) &&
                Objects.equals(profile, that.profile) &&
                Objects.equals(cardboardBrand, that.cardboardBrand) &&
                Objects.equals(celluloseLayer, that.celluloseLayer) &&
                Objects.equals(faceLayer, that.faceLayer) &&
                Objects.equals(innerLayer, that.innerLayer) &&
                Objects.equals(material, that.material) &&
                Objects.equals(specialConditions, that.specialConditions) &&
                Objects.equals(sizeWorkpieceLength, that.sizeWorkpieceLength) &&
                Objects.equals(sizeWorkpieceWidth, that.sizeWorkpieceWidth) &&
                Objects.equals(numberFromSheet, that.numberFromSheet) &&
                Objects.equals(blankFormat, that.blankFormat) &&
                Objects.equals(connectionValve, that.connectionValve) &&
                Objects.equals(stamp, that.stamp) &&
                Objects.equals(cliche, that.cliche) &&
                Objects.equals(packing, that.packing) &&
                Objects.equals(numberInPack, that.numberInPack) &&
                Objects.equals(numberInTransportPackage, that.numberInTransportPackage) &&
                Objects.equals(packageLength, that.packageLength) &&
                Objects.equals(packageWidth, that.packageWidth) &&
                Objects.equals(packageHeight, that.packageHeight) &&
                Objects.equals(pallet, that.pallet) &&
                Objects.equals(palletPlacement, that.palletPlacement) &&
                Objects.equals(palletRows, that.palletRows) &&
                Objects.equals(numberLoadCar, that.numberLoadCar) &&
                Objects.equals(productionFormat, that.productionFormat) &&
                Objects.equals(numberBlanksOnFormat, that.numberBlanksOnFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNumber, isNew, productCreateDate, productUpdateDate, personPrepared, isUse, client, productName, productType, innerLength, innerWidth, innerHeight, theoreticalSquare, actualSquare, format, profile, cardboardBrand, celluloseLayer, faceLayer, innerLayer, material, specialConditions, sizeWorkpieceLength, sizeWorkpieceWidth, numberFromSheet, blankFormat, connectionValve, stamp, cliche, packing, numberInPack, numberInTransportPackage, packageLength, packageWidth, packageHeight, pallet, palletPlacement, palletRows, numberLoadCar, productionFormat, numberBlanksOnFormat);
    }

    @Override
    public String toString() {
        return "ProductDto{" + "id=" + id +
                ", productNumber=" + productNumber +
                ", isNew=" + isNew +
                ", productCreateDate=" + productCreateDate +
                ", productUpdateDate=" + productUpdateDate +
                ", personPrepared='" + personPrepared + '\'' +
                ", isUse=" + isUse +
                ", client=" + client +
                ", productName='" + productName + '\'' +
                ", productType=" + productType +
                ", innerLength=" + innerLength +
                ", innerWidth=" + innerWidth +
                ", innerHeight=" + innerHeight +
                ", theoreticalSquare=" + theoreticalSquare +
                ", actualSquare=" + actualSquare +
                ", format=" + format +
                ", profile=" + profile +
                ", cardboardBrand=" + cardboardBrand +
                ", celluloseLayer=" + celluloseLayer +
                ", faceLayer=" + faceLayer +
                ", innerLayer=" + innerLayer +
                ", material='" + material + '\'' +
                ", specialConditions='" + specialConditions + '\'' +
                ", sizeWorkpieceLength=" + sizeWorkpieceLength +
                ", sizeWorkpieceWidth=" + sizeWorkpieceWidth +
                ", numberFromSheet=" + numberFromSheet +
                ", blankFormat=" + blankFormat +
                ", connectionValve=" + connectionValve +
                ", stamp='" + stamp + '\'' +
                ", cliche='" + cliche + '\'' +
                ", packing=" + packing +
                ", numberInPack=" + numberInPack +
                ", numberInTransportPackage=" + numberInTransportPackage +
                ", packageLength=" + packageLength +
                ", packageWidth=" + packageWidth +
                ", packageHeight=" + packageHeight +
                ", pallet=" + pallet +
                ", palletPlacement=" + palletPlacement +
                ", palletRows=" + palletRows +
                ", numberLoadCar=" + numberLoadCar +
                ", productionFormat=" + productionFormat +
                ", numberBlanksOnFormat=" + numberBlanksOnFormat +
                ", producibilityNotes=" + producibilityNotes +
                ", bigovki=" + bigovki +
                ", perforations=" + perforations +
                ", prints=" + prints +
                '}';
    }
}
