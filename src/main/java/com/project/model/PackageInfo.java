package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PACKAGE_INFO")
public class PackageInfo {

    @Id
    @Column(name = "id_package")
//    @GeneratedValue
    private int idPackage;

    @Column(name = "vulnerability")
    private String vulnerability;

    @ManyToOne
    @Column(name = "category")
    private PackageDimension category;

    public PackageInfo() {
    }

    public PackageInfo(int idPackage, String vulnerability, PackageDimension category) {
        this.idPackage = idPackage;
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
