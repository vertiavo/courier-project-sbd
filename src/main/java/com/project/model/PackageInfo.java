package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PACKAGEINFO")
public class PackageInfo implements Serializable {

    @Id
    @Column(name = "IDPACKAGE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPackage;

    @Column(name = "VULNERABILITY")
    private String vulnerability;

    @ManyToOne
    private PackageDimension category;

    public PackageInfo() {
    }

    public PackageInfo(String vulnerability, PackageDimension category) {
        this.vulnerability = vulnerability;
        this.category = category;
    }

    public int getIdPackage() {
        return idPackage;
    }

    public void setIdPackage(int idPackage) {
        this.idPackage = idPackage;
    }

    public String getVulnerability() {
        return vulnerability;
    }

    public void setVulnerability(String vulnerability) {
        this.vulnerability = vulnerability;
    }

    public PackageDimension getCategory() {
        return category;
    }

    public void setCategory(PackageDimension category) {
        this.category = category;
    }
}
