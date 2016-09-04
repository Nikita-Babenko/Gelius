package ua.skillsup.gelius.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ProductRegisterFilter {
    @JsonProperty("productNumber")
    private List<Integer> productNumbers;

    @JsonProperty("client.companyName")
    private List<String> clientNames;

    @JsonProperty("productName")
    private List<String> productNames;

    @JsonProperty("productType.productType")
    private List<String> productTypes;

    @JsonProperty("innerLength")
    private List<Integer> innerLengths;

    @JsonProperty("innerWidth")
    private List<Integer> innerWidths;

    @JsonProperty("innerHeight")
    private List<Integer> innerHeights;

    @JsonProperty("cardboardBrand.cardboardBrand")
    private List<String> cardboardBrands;

    @JsonProperty("profile.profile")
    private List<String> profiles;

    @JsonProperty("layersColours")
    private List<String> layersColours;

    @JsonProperty("cliche")
    private List<String> cliches;

    @JsonProperty("sortableColumn")
    private String sortableColumn;

    @JsonProperty("sortingDirection")
    private String sortingDirection;

    public ProductRegisterFilter() {
        productNumbers = new ArrayList<>();
        clientNames = new ArrayList<>();
        productNames = new ArrayList<>();
        productTypes = new ArrayList<>();
        innerLengths = new ArrayList<>();
        innerWidths = new ArrayList<>();
        innerHeights = new ArrayList<>();
        cardboardBrands = new ArrayList<>();
        profiles = new ArrayList<>();
        layersColours = new ArrayList<>();
        cliches = new ArrayList<>();
    }

    public List<Integer> getProductNumbers() {
        return productNumbers;
    }

    public void setProductNumbers(List<Integer> productNumbers) {
        this.productNumbers = productNumbers;
    }

    public List<String> getClientNames() {
        return clientNames;
    }

    public void setClientNames(List<String> clientNames) {
        this.clientNames = clientNames;
    }

    public List<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(List<String> productNames) {
        this.productNames = productNames;
    }

    public List<String> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(List<String> productTypes) {
        this.productTypes = productTypes;
    }

    public List<Integer> getInnerLengths() {
        return innerLengths;
    }

    public void setInnerLengths(List<Integer> innerLengths) {
        this.innerLengths = innerLengths;
    }

    public List<Integer> getInnerWidths() {
        return innerWidths;
    }

    public void setInnerWidths(List<Integer> innerWidths) {
        this.innerWidths = innerWidths;
    }

    public List<Integer> getInnerHeights() {
        return innerHeights;
    }

    public void setInnerHeights(List<Integer> innerHeights) {
        this.innerHeights = innerHeights;
    }

    public List<String> getCardboardBrands() {
        return cardboardBrands;
    }

    public void setCardboardBrands(List<String> cardboardBrands) {
        this.cardboardBrands = cardboardBrands;
    }

    public List<String> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<String> profiles) {
        this.profiles = profiles;
    }

    public List<String> getLayersColours() {
        return layersColours;
    }

    public void setLayersColours(List<String> layersColours) {
        this.layersColours = layersColours;
    }

    public List<String> getCliches() {
        return cliches;
    }

    public void setCliches(List<String> cliches) {
        this.cliches = cliches;
    }

    public String getSortableColumn() {
        return sortableColumn;
    }

    public void setSortableColumn(String sortableColumn) {
        this.sortableColumn = sortableColumn;
    }

    public String getSortingDirection() {
        return sortingDirection;
    }

    public void setSortingDirection(String sortingDirection) {
        this.sortingDirection = sortingDirection;
    }


    public boolean isEmpty() {
        return ((productNumbers == null) || productNumbers.isEmpty())
                && ((clientNames == null) || clientNames.isEmpty())
                && ((productNames == null) || productNames.isEmpty())
                && ((productTypes == null) || productTypes.isEmpty())
                && ((innerLengths == null) || innerLengths.isEmpty())
                && ((innerWidths == null) || innerWidths.isEmpty())
                && ((innerHeights == null) || innerHeights.isEmpty())
                && ((cardboardBrands == null) || cardboardBrands.isEmpty())
                && ((profiles == null) || profiles.isEmpty())
                && ((layersColours == null) || layersColours.isEmpty())
                && ((cliches == null) || cliches.isEmpty())
                && ((sortableColumn == null) || sortableColumn.length() == 0);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductRegisterFilter{");
        sb.append("productNumbers=").append(productNumbers);
        sb.append(", clientNames=").append(clientNames);
        sb.append(", productNames=").append(productNames);
        sb.append(", productTypes=").append(productTypes);
        sb.append(", innerLengths=").append(innerLengths);
        sb.append(", innerWidths=").append(innerWidths);
        sb.append(", innerHeights=").append(innerHeights);
        sb.append(", cardboardBrands=").append(cardboardBrands);
        sb.append(", profiles=").append(profiles);
        sb.append(", layersColours=").append(layersColours);
        sb.append(", cliches=").append(cliches);
        sb.append(", sortableColumn='").append(sortableColumn).append('\'');
        sb.append(", sortingDirection='").append(sortingDirection).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
