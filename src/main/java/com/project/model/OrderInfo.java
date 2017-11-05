package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "ORDERINFO")
@SequenceGenerator(name = "orderInfo_id_seq", allocationSize = 1, sequenceName = "orderInfo_id_seq")
public class OrderInfo implements Serializable {

    @Id
    @Column(name = "IDORDER")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "orderInfo_id_seq")
    private Integer idOrder;

    @ManyToOne
    private Sender idSender;

    @ManyToOne
    private Recipient idRecipient;

    @ManyToOne
    private Courier idCourier;

    @ManyToOne
    private PackageInfo idPackage;

    @ManyToOne
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

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
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
