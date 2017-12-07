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
@Table(name = "PAYMENT")
@SequenceGenerator(name = "payment_id_seq", allocationSize = 1, sequenceName = "payment_id_seq")
public class Payment implements Serializable {

    private static final long serialVersionUID = -5903120592270636907L;

    @Id
    @Column(name = "IDPAYMENT")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "payment_id_seq")
    private Integer idPayment;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "TYPE")
    private String type;

    public Payment() {
    }

    public Payment(Double price, String type) {
        this.price = price;
        this.type = type;
    }

    public Integer getIdPayment() {
        return idPayment;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (!idPayment.equals(payment.idPayment)) return false;
        if (!price.equals(payment.price)) return false;
        return type.equals(payment.type);
    }

    @Override
    public int hashCode() {
        int result = idPayment.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return idPayment.toString();
    }
}
