package ua.skillsup.gelius.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductsFilteringAndSortingDTO {

    private List<Long> ids;

    private List<String> clients;

    private List<String> names;

    private List<String> types;

    private List<Integer> lengths;

    private List<Integer> widths;

    private List<Integer> heights;

    private List<String> grades;

    private List<String> profiles;

    private List<String> colours;

    private List<String> prints;

    private String sortableColumn;

    private String sortingDirection;

    public ProductsFilteringAndSortingDTO() {
        ids = new ArrayList<>();
        clients = new ArrayList<>();
        names = new ArrayList<>();
        types = new ArrayList<>();
        lengths = new ArrayList<>();
        widths = new ArrayList<>();
        heights = new ArrayList<>();
        grades = new ArrayList<>();
        profiles = new ArrayList<>();
        colours = new ArrayList<>();
        prints = new ArrayList<>();
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public List<String> getClients() {
        return clients;
    }

    public void setClients(List<String> clients) {
        this.clients = clients;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<Integer> getLengths() {
        return lengths;
    }

    public void setLengths(List<Integer> lengths) {
        this.lengths = lengths;
    }

    public List<Integer> getWidths() {
        return widths;
    }

    public void setWidths(List<Integer> widths) {
        this.widths = widths;
    }

    public List<Integer> getHeights() {
        return heights;
    }

    public void setHeights(List<Integer> heights) {
        this.heights = heights;
    }

    public List<String> getGrades() {
        return grades;
    }

    public void setGrades(List<String> grades) {
        this.grades = grades;
    }

    public List<String> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<String> profiles) {
        this.profiles = profiles;
    }

    public List<String> getColours() {
        return colours;
    }

    public void setColours(List<String> colours) {
        this.colours = colours;
    }

    public List<String> getPrints() {
        return prints;
    }

    public void setPrints(List<String> prints) {
        this.prints = prints;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductsFilteringAndSortingDTO)) return false;
        ProductsFilteringAndSortingDTO that = (ProductsFilteringAndSortingDTO) o;
        return Objects.equals(getIds(), that.getIds()) &&
                Objects.equals(getClients(), that.getClients()) &&
                Objects.equals(getNames(), that.getNames()) &&
                Objects.equals(getTypes(), that.getTypes()) &&
                Objects.equals(getLengths(), that.getLengths()) &&
                Objects.equals(getWidths(), that.getWidths()) &&
                Objects.equals(getHeights(), that.getHeights()) &&
                Objects.equals(getGrades(), that.getGrades()) &&
                Objects.equals(getProfiles(), that.getProfiles()) &&
                Objects.equals(getColours(), that.getColours()) &&
                Objects.equals(getPrints(), that.getPrints()) &&
                Objects.equals(getSortableColumn(), that.getSortableColumn()) &&
                Objects.equals(getSortingDirection(), that.getSortingDirection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIds(), getClients(), getNames(), getTypes(), getLengths(), getWidths(), getHeights(), getGrades(), getProfiles(), getColours(), getPrints(), getSortableColumn(), getSortingDirection());
    }

    public Boolean isEmpty() {
        return ((ids == null) ? true : ids.isEmpty())
                && ((clients == null) ? true : clients.isEmpty())
                && ((names == null) ? true : names.isEmpty())
                && ((types == null) ? true : types.isEmpty())
                && ((lengths == null) ? true : lengths.isEmpty())
                && ((widths == null) ? true : widths.isEmpty())
                && ((heights == null) ? true : heights.isEmpty())
                && ((grades == null) ? true : grades.isEmpty())
                && ((profiles == null) ? true : profiles.isEmpty())
                && ((colours == null) ? true : colours.isEmpty())
                && ((prints == null) ? true : prints.isEmpty())
                && ((sortableColumn == null) ? true : sortableColumn.length() == 0);
    }

    @Override
    public String toString() {
        return "ProductsFilteringAndSortingDTO{" +
                "ids=" + ids +
                ", clients=" + clients +
                ", names=" + names +
                ", types=" + types +
                ", lengths=" + lengths +
                ", widths=" + widths +
                ", heights=" + heights +
                ", grades=" + grades +
                ", profiles=" + profiles +
                ", colours=" + colours +
                ", prints=" + prints +
                ", sortableColumn='" + sortableColumn + '\'' +
                ", sortingDirection='" + sortingDirection + '\'' +
                '}';
    }
}
