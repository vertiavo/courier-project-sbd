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
@Table(name = "RECIPIENT")
@SequenceGenerator(name = "recipient_id_seq", allocationSize = 1, sequenceName = "recipient_id_seq")
public class Recipient implements Serializable {

    private static final long serialVersionUID = -2368218360506489268L;

    @Id
    @Column(name = "IDRECIPIENT")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "recipient_id_seq")
    private Integer idRecipient;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONENUMBER")
    private Integer phoneNumber;

    public Recipient() {
    }

    public Recipient(String name, String surname, String address, Integer phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getIdRecipient() {
        return idRecipient;
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

        Recipient recipient = (Recipient) o;

        if (!idRecipient.equals(recipient.idRecipient)) return false;
        if (!name.equals(recipient.name)) return false;
        if (!surname.equals(recipient.surname)) return false;
        if (!address.equals(recipient.address)) return false;
        return phoneNumber.equals(recipient.phoneNumber);
    }

    @Override
    public int hashCode() {
        int result = idRecipient.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }
}
