package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "SENDER")
@SequenceGenerator(name = "sender_id_seq", allocationSize = 1, sequenceName = "sender_id_seq")
public class Sender implements Serializable {

    @Id
    @Column(name = "IDSENDER")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sender_id_seq")
    private Integer idSender;

    @Column(name = "ADDRESS")
    private String address;

    @ManyToOne
    private Offer offerType;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "NIP")
    private Integer nip;

    public Sender() {
    }

    public Sender(String address, Offer offerType, String name, String surname, Integer nip) {
        this.address = address;
        this.offerType = offerType;
        this.name = name;
        this.surname = surname;
        this.nip = nip;
    }

    public Integer getIdSender() {
        return idSender;
    }

    public void setIdSender(Integer idSender) {
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

    public Integer getNip() {
        return nip;
    }

    public void setNip(Integer nip) {
        this.nip = nip;
    }
}
