package com.project.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "OFFER")
public class Offer implements Serializable {

    private static final long serialVersionUID = -6047154146312102587L;

    @Id
    @Column(name = "OFFERTYPE")
    private String offerType;

    @Column(name = "DISCOUNT")
    private Integer discount;

    public Offer() {
    }

    public Offer(String offerType, Integer discount) {
        this.offerType = offerType;
        this.discount = discount;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Offer offer = (Offer) o;

        if (!offerType.equals(offer.offerType)) return false;
        return discount.equals(offer.discount);
    }

    @Override
    public int hashCode() {
        int result = offerType.hashCode();
        result = 31 * result + discount.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return offerType;
    }
}
