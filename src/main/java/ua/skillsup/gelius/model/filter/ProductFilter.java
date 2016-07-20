package ua.skillsup.gelius.model.filter;

public class ProductFilter {
    private Integer lengthFrom;
    private Integer lengthTo;
    private Integer widthFrom;
    private Integer widthTo;
    private Integer heightFrom;
    private Integer heightTo;

    public Integer getLengthFrom() {
        return lengthFrom;
    }

    public void setLengthFrom(Integer lengthFrom) {
        this.lengthFrom = lengthFrom;
    }

    public Integer getLengthTo() {
        return lengthTo;
    }

    public void setLengthTo(Integer lengthTo) {
        this.lengthTo = lengthTo;
    }

    public Integer getWidthFrom() {
        return widthFrom;
    }

    public void setWidthFrom(Integer widthFrom) {
        this.widthFrom = widthFrom;
    }

    public Integer getWidthTo() {
        return widthTo;
    }

    public void setWidthTo(Integer widthTo) {
        this.widthTo = widthTo;
    }

    public Integer getHeightFrom() {
        return heightFrom;
    }

    public void setHeightFrom(Integer heightFrom) {
        this.heightFrom = heightFrom;
    }

    public Integer getHeightTo() {
        return heightTo;
    }

    public void setHeightTo(Integer heightTo) {
        this.heightTo = heightTo;
    }

    @Override
    public String toString() {
        return "ProductFilter{" +
                "lengthFrom=" + lengthFrom +
                ", lengthTo=" + lengthTo +
                ", widthFrom=" + widthFrom +
                ", widthTo=" + widthTo +
                ", heightFrom=" + heightFrom +
                ", heightTo=" + heightTo +
                '}';
    }
}
