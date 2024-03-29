package com.project.model;

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
import java.sql.Date;

@Entity
@Table(name = "ORDERINFO")
@SequenceGenerator(name = "orderInfo_id_seq", allocationSize = 1, sequenceName = "orderInfo_id_seq")
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = -6233008236801512952L;

    @Id
    @Column(name = "IDORDER")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "orderInfo_id_seq")
    private Integer idOrder;

    @ManyToOne
    @JoinColumn(name = "IDSENDER", referencedColumnName = "IDSENDER")
    private Sender idSender;

    @ManyToOne
    @JoinColumn(name = "IDRECIPIENT", referencedColumnName = "IDRECIPIENT")
    private Recipient idRecipient;

    @ManyToOne
    @JoinColumn(name = "IDCOURIER", referencedColumnName = "IDCOURIER")
    private Courier idCourier;

    @ManyToOne
    @JoinColumn(name = "IDPACKAGE", referencedColumnName = "IDPACKAGE")
    private PackageInfo idPackage;

    @ManyToOne
    @JoinColumn(name = "IDPAYMENT", referencedColumnName = "IDPAYMENT")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderInfo orderInfo = (OrderInfo) o;

        if (!idOrder.equals(orderInfo.idOrder)) return false;
        if (!idSender.equals(orderInfo.idSender)) return false;
        if (!idRecipient.equals(orderInfo.idRecipient)) return false;
        if (!idCourier.equals(orderInfo.idCourier)) return false;
        if (!idPackage.equals(orderInfo.idPackage)) return false;
        if (!idPayment.equals(orderInfo.idPayment)) return false;
        return orderDate.equals(orderInfo.orderDate);
    }

    @Override
    public int hashCode() {
        int result = idOrder.hashCode();
        result = 31 * result + idSender.hashCode();
        result = 31 * result + idRecipient.hashCode();
        result = 31 * result + idCourier.hashCode();
        result = 31 * result + idPackage.hashCode();
        result = 31 * result + idPayment.hashCode();
        result = 31 * result + orderDate.hashCode();
        return result;
    }
}
