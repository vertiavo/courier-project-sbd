package com.project.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class CourierCarAreaId implements Serializable {

    @OneToOne
    @JoinColumn(name = "IDCOURIER", referencedColumnName = "IDCOURIER")
    private Courier idCourier;

    @Column(name = "BEGINDATE")
    private Date beginDate;

    public CourierCarAreaId() {
    }

    public CourierCarAreaId(Courier idCourier, Date beginDate) {
        this.idCourier = idCourier;
        this.beginDate = beginDate;
    }

    public Courier getIdCourier() {
        return idCourier;
    }

    public void setIdCourier(Courier idCourier) {
        this.idCourier = idCourier;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourierCarAreaId that = (CourierCarAreaId) o;

        if (!idCourier.equals(that.idCourier)) return false;
        return beginDate.equals(that.beginDate);
    }

    @Override
    public int hashCode() {
        int result = idCourier.hashCode();
        result = 31 * result + beginDate.hashCode();
        return result;
    }
}
