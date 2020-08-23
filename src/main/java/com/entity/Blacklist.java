package com.entity;

import java.util.Date;

public class Blacklist {
    Integer bid;
    Integer uid;
    String context;
    Date times;

    public Blacklist() {
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "Blacklist{" +
                "bid=" + bid +
                ", uid=" + uid +
                ", context='" + context + '\'' +
                ", times=" + times +
                '}';
    }
}
