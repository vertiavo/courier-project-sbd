package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "ORDERINFO")
public class OrderInfo implements Serializable {

    @Id
    @Column(name = "IDORDER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;

    @ManyToOne
    @Column(name = "IDSENDER")
    private Sender idSender;

    @ManyToOne
    @Column(name = "IDRECIPIENT")
    private Recipient idRecipient;

    @ManyToOne
    @Column(name = "IDCOURIER")
    private Courier idCourier;

    @ManyToOne
    @Column(name = "IDPACKAGE")
    private PackageInfo idPackage;

    @ManyToOne
    @Column(name = "IDPAYMENT")
    private Payment idPayment;

    @Column(name = "ORDERDATE")
    private Date orderDate;

    public OrderInfo() {
    }

    public OrderInfo(Sender idSender, Recipient idRecipient, Courier idCourier, PackageInfo idPackage, Payment idPayment, Date orderDate) {
        this.idSender = idSender;
        this.idRecipient = idRecipient;
        this.idCourier = idCourier;
        this.idPackage = idPackage;
        this.idPayment = idPayment;
        this.orderDate = orderDate;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Sender getIdSender() {
        return idSender;
    }

    public void setIdSender(Sender idSender) {
        this.idSender = idSender;
    }

    public Recipient getIdRecipient() {
        return idRecipient;
    }

    public void setIdRecipient(Recipient idRecipient) {
        this.idRecipient = idRecipient;
    }

    public Courier getIdCourier() {
        return idCourier;
    }

    public void setIdCourier(Courier idCourier) {
        this.idCourier = idCourier;
    }

    public PackageInfo getIdPackage() {
        return idPackage;
    }

    public void setIdPackage(PackageInfo idPackage) {
        this.idPackage = idPackage;
    }

    public Payment getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Payment idPayment) {
        this.idPayment = idPayment;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
