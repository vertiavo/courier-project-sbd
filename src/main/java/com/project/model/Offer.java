package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "OFFER")
public class Offer implements Serializable {

    @Id
    @Column(name = "OFFERTYPE")
    private String offerType;

    @Column(name = "DISCOUNT")
    private Integer discount;

    public Offer() {
    }

    public Offer(String offerType, int discount) {
        this.offerType = offerType;
        this.discount = discount;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
