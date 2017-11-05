package com.project.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "COURIERCARAREA")
public class CourierCarArea implements Serializable {

    @EmbeddedId
    private CourierCarAreaId idCourierCarArea;

    @ManyToOne
    private Car idCar;

    @ManyToOne
    private Area idArea;

    @Column(name = "ENDDATE")
    private Date endDate;

    public CourierCarArea() {
    }

    public CourierCarArea(CourierCarAreaId idCourierCarArea, Car idCar, Area idArea, Date endDate) {
        this.idCourierCarArea = idCourierCarArea;
        this.idCar = idCar;
        this.idArea = idArea;
        this.endDate = endDate;
    }

    public CourierCarAreaId getIdCourierCarArea() {
        return idCourierCarArea;
    }

    public void setIdCourierCarArea(CourierCarAreaId idCourierCarArea) {
        this.idCourierCarArea = idCourierCarArea;
    }

    public Car getIdCar() {
        return idCar;
    }

    public void setIdCar(Car idCar) {
        this.idCar = idCar;
    }

    public Area getIdArea() {
        return idArea;
    }

    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
