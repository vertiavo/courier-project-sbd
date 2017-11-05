package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PACKAGEDIMENSION")
public class PackageDimension implements Serializable {

    @Id
    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "MAXWEIGHT")
    private Double maxWeight;

    @Column(name = "MAXVOLUME")
    private Double maxVolume;

    public PackageDimension() {
    }

    public PackageDimension(String category, double maxWeight, double maxVolume) {
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

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(double maxVolume) {
        this.maxVolume = maxVolume;
    }
}
