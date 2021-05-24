import java.util.Objects;

public class Salesman implements Comparable<Salesman> {
    private String name;
    private Integer totalSales;
    private Integer salesPeriod;
    private Double experienceMultiplier;
    private Double score;

    public Salesman(String name, Integer totalSales, Integer salesPeriod, Double experienceMultiplier) {
        this.name = name;
        this.totalSales = totalSales;
        this.salesPeriod = salesPeriod;
        this.experienceMultiplier = experienceMultiplier;
    }

    public Salesman() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    public Integer getSalesPeriod() {
        return salesPeriod;
    }

    public void setSalesPeriod(Integer salesPeriod) {
        this.salesPeriod = salesPeriod;
    }

    public Double getExperienceMultiplier() {
        return experienceMultiplier;
    }

    public void setExperienceMultiplier(Double experienceMultiplier) {
        this.experienceMultiplier = experienceMultiplier;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void calculateScore(boolean useExperienceMultiplier) {
        if (useExperienceMultiplier) {
            this.score = this.totalSales / (this.salesPeriod * this.experienceMultiplier);
        } else {
            this.score = this.totalSales / this.salesPeriod * 1D;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salesman salesman = (Salesman) o;
        return this.getScore().equals(salesman.getScore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public int compareTo(Salesman o) {
        return this.getScore().compareTo(o.getScore());
    }

    @Override
    public String toString() {
        return String.format("%s, %.1f", this.name, this.score);
    }
}
