package ua.skillsup.gelius.dto;

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> getHeights() {
        return heights;
    }

    public void setHeights(List<Integer> heights) {
        this.heights = heights;
    }

    public List<Integer> getWidths() {
        return widths;
    }

    public void setWidths(List<Integer> widths) {
        this.widths = widths;
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
                && ((prints == null) ? true : prints.isEmpty());
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
                '}';
    }
}
