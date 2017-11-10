package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "AREA")
@SequenceGenerator(name = "area_id_seq", allocationSize = 1, sequenceName = "area_id_seq")
public class Area implements Serializable {

    private static final long serialVersionUID = 31130138911259853L;

    @Id
    @Column(name = "IDAREA")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "area_id_seq")
    private Integer idArea;

    @Column(name = "NAME")
    private String name;

    public Area() {
    }

    public Area(String name) {
        this.name = name;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
