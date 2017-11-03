package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CAR")
public class Car implements Serializable {

    @Id
    @Column(name = "IDCAR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCar;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "LOAD")
    private double load;

    @Column(name = "CAPACITY")
    private double capacity;

    public Car() {
    }

    public Car(String brand, String model, double load, double capacity) {
        this.brand = brand;
        this.model = model;
        this.load = load;
        this.capacity = capacity;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
}
