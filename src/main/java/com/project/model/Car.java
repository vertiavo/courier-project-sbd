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
@Table(name = "CAR")
@SequenceGenerator(name = "car_id_seq", allocationSize = 1, sequenceName = "car_id_seq")
public class Car implements Serializable {

    @Id
    @Column(name = "IDCAR")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "car_id_seq")
    private Integer idCar;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "LOAD")
    private Double load;

    @Column(name = "CAPACITY")
    private Double capacity;

    public Car() {
    }

    public Car(String brand, String model, Double load, Double capacity) {
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

    public Double getLoad() {
        return load;
    }

    public void setLoad(Double load) {
        this.load = load;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }
}
