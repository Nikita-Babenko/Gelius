package ua.skillsup.gelius.dto;

import java.util.List;

public class ProductsSearchFilter {

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

    public ProductsSearchFilter() {
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
        return clients.isEmpty() && names.isEmpty() && types.isEmpty() && lengths.isEmpty()
                && widths.isEmpty() && heights.isEmpty() && grades.isEmpty() && profiles.isEmpty()
                && colours.isEmpty() && prints.isEmpty();
    }
}
