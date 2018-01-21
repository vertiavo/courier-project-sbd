package com.project.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "SENDER")
@SequenceGenerator(name = "sender_id_seq", allocationSize = 1, sequenceName = "sender_id_seq")
public class Sender implements Serializable {

    private static final long serialVersionUID = 220053935647179065L;

    @Id
    @Column(name = "IDSENDER")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sender_id_seq")
    private Integer idSender;

    @Column(name = "ADDRESS")
    private String address;

    @ManyToOne
    @JoinColumn(name = "OFFERTYPE")
    private Offer offerType;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "NIP")
    private Integer nip;

    public Sender() {
    }

    public Sender(String name, String surname, String address, Offer offerType, Integer nip) {
        this.address = address;
        this.offerType = offerType;
        this.name = name;
        this.surname = surname;
        this.nip = nip;

    }

    public Integer getIdSender() {
        return idSender;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sender sender = (Sender) o;

        if (!idSender.equals(sender.idSender)) return false;
        if (!address.equals(sender.address)) return false;
        if (!offerType.equals(sender.offerType)) return false;
        if (!name.equals(sender.name)) return false;
        if (!surname.equals(sender.surname)) return false;
        return nip != null ? nip.equals(sender.nip) : sender.nip == null;
    }

    @Override
    public int hashCode() {
        int result = idSender.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + offerType.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + (nip != null ? nip.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return idSender.toString();
    }
}
