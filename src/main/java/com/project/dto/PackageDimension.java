package com.project.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PACKAGEDIMENSION")
public class PackageDimension implements Serializable {

    private static final long serialVersionUID = 5956498803173741448L;

    @Id
    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "MAXWEIGHT")
    private Double maxWeight;

    @Column(name = "MAXVOLUME")
    private Double maxVolume;

    public PackageDimension() {
    }

    public PackageDimension(String category, Double maxWeight, Double maxVolume) {
        this.category = category;
        this.maxWeight = maxWeight;
        this.maxVolume = maxVolume;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Double getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(Double maxVolume) {
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackageDimension that = (PackageDimension) o;

        if (!category.equals(that.category)) return false;
        if (!maxWeight.equals(that.maxWeight)) return false;
        return maxVolume.equals(that.maxVolume);
    }

    @Override
    public int hashCode() {
        int result = category.hashCode();
        result = 31 * result + maxWeight.hashCode();
        result = 31 * result + maxVolume.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return category;
    }
}
