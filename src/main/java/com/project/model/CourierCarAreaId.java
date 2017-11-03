package com.project.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;

@Embeddable
public class CourierCarAreaId implements Serializable {

    @Column(name = "IDCOURIER")
    private int idCourier;

    @Column(name = "BEGINDATE")
    private Date beginDate;

    public CourierCarAreaId() {
    }

    public CourierCarAreaId(int idCourier, Date beginDate) {
        this.idCourier = idCourier;
        this.beginDate = beginDate;
    }

    public int getIdCourier() {
        return idCourier;
    }

    public void setIdCourier(int idCourier) {
        this.idCourier = idCourier;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }
}
