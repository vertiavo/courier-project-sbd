package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "ORDER_INFO")
public class OrderInfo {

    @Id
    @Column(name = "id_order")
//    @GeneratedValue
    private int idOrder;

    @OneToMany
    @Column(name = "id_sender")
    private Sender idSender;

    @OneToMany
    @Column(name = "id_recipient")
    private Recipient idRecipient;

    @OneToMany
    @Column(name = "id_courier")
    private Courier idCourier;

    @ManyToOne
    @Column(name = "id_package")
    private PackageInfo idPackage;

    @OneToMany
    @Column(name = "id_payment")
    private Payment idPayment;

    @Column(name = "order_date")
    private Date orderDate;

    public OrderInfo() {
    }

    public OrderInfo(int idOrder, Sender idSender, Recipient idRecipient, Courier idCourier, PackageInfo idPackage, Payment idPayment, Date orderDate) {
        this.idOrder = idOrder;
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
