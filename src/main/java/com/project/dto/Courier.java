package com.project.dto;

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

    private static final long serialVersionUID = 5870649598423599935L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Courier courier = (Courier) o;

        if (!idCourier.equals(courier.idCourier)) return false;
        if (!name.equals(courier.name)) return false;
        if (!surname.equals(courier.surname)) return false;
        if (!address.equals(courier.address)) return false;
        return phoneNumber.equals(courier.phoneNumber);
    }

    @Override
    public int hashCode() {
        int result = idCourier.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return idCourier.toString();
    }
}
