package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OFFER")
public class Offer {

    @Id
    @Column(name = "offer_type")
    private String offerType;

    @Column(name = "discount")
    private int discount;

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
