package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SENDER")
public class Sender {

    @Id
    @Column(name = "id_sender")
//    @GeneratedValue
    private int idSender;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @Column(name = "offer_type")
    private Offer offerType;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "nip")
    private int nip;

    public Sender() {
    }

    public Sender(int idSender, String address, Offer offerType, String name, String surname, int nip) {
        this.idSender = idSender;
        this.address = address;
        this.offerType = offerType;
        this.name = name;
        this.surname = surname;
        this.nip = nip;
    }

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Offer getOfferType() {
        return offerType;
    }

    public void setOfferType(Offer offerType) {
        this.offerType = offerType;
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

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }
}
