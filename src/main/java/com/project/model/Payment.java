package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @Column(name = "id_payment")
//    @GeneratedValue
    private int idPayment;

    @Column(name = "price")
    private double price;

    @Column(name = "type")
    private String type;

    public Payment() {
    }

    public Payment(int idPayment, double price, String type) {
        this.idPayment = idPayment;
        this.price = price;
        this.type = type;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
