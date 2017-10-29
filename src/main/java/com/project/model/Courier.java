package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COURIER")
public class Courier {

    @Id
    @Column(name = "id_courier")
//    @GeneratedValue
    private int idCourier;

    @OneToOne
    @Column(name = "id_car")
    private Car idCar;

    @Column(name = "area")
    private String area;

    public Courier() {
    }

    public Courier(int idCourier, Car idCar, String area) {
        this.idCourier = idCourier;
        this.idCar = idCar;
        this.area = area;
    }

    public int getIdCourier() {
        return idCourier;
    }

    public void setIdCourier(int idCourier) {
        this.idCourier = idCourier;
    }

    public Car getIdCar() {
        return idCar;
    }

    public void setIdCar(Car idCar) {
        this.idCar = idCar;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
