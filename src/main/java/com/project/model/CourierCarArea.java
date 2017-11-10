package com.project.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "COURIERCARAREA")
public class CourierCarArea implements Serializable {

    private static final long serialVersionUID = -5758624919070579970L;

    @EmbeddedId
    private CourierCarAreaId idCourierCarArea;

    @ManyToOne
    @JoinColumn(name = "IDCAR", referencedColumnName = "IDCAR")
    private Car idCar;

    @ManyToOne
    @JoinColumn(name = "IDAREA", referencedColumnName = "IDAREA")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourierCarArea that = (CourierCarArea) o;

        if (!idCourierCarArea.equals(that.idCourierCarArea)) return false;
        if (!idCar.equals(that.idCar)) return false;
        if (!idArea.equals(that.idArea)) return false;
        return endDate != null ? endDate.equals(that.endDate) : that.endDate == null;
    }

    @Override
    public int hashCode() {
        int result = idCourierCarArea.hashCode();
        result = 31 * result + idCar.hashCode();
        result = 31 * result + idArea.hashCode();
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }
}
