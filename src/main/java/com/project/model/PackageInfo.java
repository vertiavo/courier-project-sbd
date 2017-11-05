package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PACKAGEINFO")
@SequenceGenerator(name = "packageInfo_id_seq", allocationSize = 1, sequenceName = "packageInfo_id_seq")
public class PackageInfo implements Serializable {

    @Id
    @Column(name = "IDPACKAGE")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "packageInfo_id_seq")
    private Integer idPackage;

    @Column(name = "VULNERABILITY")
    private String vulnerability;

    @ManyToOne
    @JoinColumn(name = "CATEGORY", referencedColumnName = "CATEGORY")
    private PackageDimension category;

    public PackageInfo() {
    }

    public PackageInfo(String vulnerability, PackageDimension category) {
        this.vulnerability = vulnerability;
        this.category = category;
    }

    public Integer getIdPackage() {
        return idPackage;
    }

    public void setIdPackage(Integer idPackage) {
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
