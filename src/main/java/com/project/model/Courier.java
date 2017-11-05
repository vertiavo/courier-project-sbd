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
@Table(name = "COURIER")
@SequenceGenerator(name = "courier_id_seq", allocationSize = 1, sequenceName = "courier_id_seq")
public class Courier implements Serializable {

    @Id
    @Column(name = "IDCOURIER")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "courier_id_seq")
    private Integer idCourier;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONENUMBER")
    private Integer phoneNumber;

    public Courier() {
    }

    public Courier(String name, String surname, String address, Integer phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getIdCourier() {
        return idCourier;
    }

    public void setIdCourier(Integer idCourier) {
        this.idCourier = idCourier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
