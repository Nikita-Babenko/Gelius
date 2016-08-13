package ua.skillsup.gelius.model.dto;

import java.util.ArrayList;
import java.util.List;


public class ProductRegisterFilter {

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

    public ProductRegisterFilter() {
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


    public boolean isEmpty() {
        return ((ids == null) || ids.isEmpty())
                && ((clients == null) || clients.isEmpty())
                && ((names == null) || names.isEmpty())
                && ((types == null) || types.isEmpty())
                && ((lengths == null) || lengths.isEmpty())
                && ((widths == null) || widths.isEmpty())
                && ((heights == null) || heights.isEmpty())
                && ((grades == null) || grades.isEmpty())
                && ((profiles == null) || profiles.isEmpty())
                && ((colours == null) || colours.isEmpty())
                && ((prints == null) || prints.isEmpty())
                && ((sortableColumn == null) || sortableColumn.length() == 0);
    }


}
