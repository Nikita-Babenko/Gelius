package ua.skillsup.gelius.dao.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ua.skillsup.gelius.dao.entity.dictionary.*;
import ua.skillsup.gelius.util.LocalDateConverter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_number")
    private Integer productNumber;

    @Column(name = "isNew")
    private Boolean isNew;

    @Column(name = "product_create")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate productCreateDate;

    @Column(name = "product_update")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate productUpdateDate;

    @Size(max = 50)
    @Column(name = "person_prepared")
    private String personPrepared;

    @Column(name = "isUse")
    private Boolean isUse;

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

    @Column(name = "theoretical_square", precision = 5, scale = 3)
    private Double theoreticalSquare;

    @Column(name = "actual_square", precision = 5, scale = 3)
    private Double actualSquare;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "format_id")
    private Format format;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "cardboard_brand_id")
    private CardboardBrand cardboardBrand;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "cellulose_layer_id")
    private CelluloseLayer celluloseLayer;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "face_layer_id")
    private FaceLayer faceLayer;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "inner_layer_id")
    private InnerLayer innerLayer;

    @Size(max = 200)
    @Column(name = "specialConditions")
    private String specialConditions;

    @Size(max = 200)
    @Column(name = "material")
    private String material;

    @Column(name = "size_workpiece_length")
    private Integer sizeWorkpieceLength;

    @Column(name = "size_workpiece_width")
    private Integer sizeWorkpieceWidth;

    @Column(name = "number_from_sheet")
    private Integer numberFromSheet;

    @Column(name = "blank_format")
    private Integer blankFormat;

    @ManyToOne
    @JoinColumn(name = "connection_valve_id")
    private ConnectionValve connectionValve;

    @Size(max = 50)
    @Column(name = "stamp")
    private String stamp;

    @Size(max = 50)
    @Column(name = "cliche")
    private String cliche;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "packing_id")
    private Packing packing;

    @Column(name = "number_in_pack")
    private Integer numberInPack;

    @Column(name = "number_in_transport_package")
    private Integer numberInTransportPackage;

    @Column(name = "package_length")
    private Integer packageLength;

    @Column(name = "package_width")
    private Integer packageWidth;

    @Column(name = "package_height")
    private Integer packageHeight;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "pallet_id")
    private Pallet pallet;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "pallet_placement_id")
    private PalletPlacement palletPlacement;

    @Column(name = "pallet_rows")
    private Integer palletRows;

    @Column(name = "number_load_car")
    private Integer numberLoadCar;

    @Column(name = "production_format")
    private Integer productionFormat;

    @Column(name = "numberBlanksOnFormat")
    private Integer numberBlanksOnFormat;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<WorkabilityNotes> workabilityNotes;

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

    public CelluloseLayer getCelluloseLayer() {
        return celluloseLayer;
    }

    public void setCelluloseLayer(CelluloseLayer celluloseLayer) {
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

    public String getSpecialConditions() {
        return specialConditions;
    }

    public void setSpecialConditions(String specialConditions) {
        this.specialConditions = specialConditions;
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

    public Integer getNumberBlanksOnFormat() {
        return numberBlanksOnFormat;
    }

    public void setNumberBlanksOnFormat(Integer numberBlanksOnFormat) {
        this.numberBlanksOnFormat = numberBlanksOnFormat;
    }

    public List<WorkabilityNotes> getWorkabilityNotes() {
        return workabilityNotes;
    }

    public void setWorkabilityNotes(List<WorkabilityNotes> workabilityNotes) {
        this.workabilityNotes = workabilityNotes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
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
        sb.append(", specialConditions='").append(specialConditions).append('\'');
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
        sb.append(", numberBlanksOnFormat=").append(numberBlanksOnFormat);
        sb.append(", workabilityNotes=").append(workabilityNotes);
        sb.append('}');
        return sb.toString();
    }
}
