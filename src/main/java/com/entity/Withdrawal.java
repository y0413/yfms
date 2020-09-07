package com.entity;

import java.util.Date;

public class Withdrawal {
    Integer wid;
    Integer uid;
    Date times;
    Double total_price;
    Integer coll_mode;

    public Withdrawal() {
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public Integer getColl_mode() {
        return coll_mode;
    }

    public void setColl_mode(Integer coll_mode) {
        this.coll_mode = coll_mode;
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "wid=" + wid +
                ", uid=" + uid +
                ", times='" + times + '\'' +
                ", total_price=" + total_price +
                ", coll_mode=" + coll_mode +
                '}';
    }
}
