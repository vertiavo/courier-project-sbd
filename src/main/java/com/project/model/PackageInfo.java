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

    private static final long serialVersionUID = 9058825483221024079L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackageInfo that = (PackageInfo) o;

        if (!idPackage.equals(that.idPackage)) return false;
        if (!vulnerability.equals(that.vulnerability)) return false;
        return category.equals(that.category);
    }

    @Override
    public int hashCode() {
        int result = idPackage.hashCode();
        result = 31 * result + vulnerability.hashCode();
        result = 31 * result + category.hashCode();
        return result;
    }
}
