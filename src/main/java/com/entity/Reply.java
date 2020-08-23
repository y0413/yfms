package com.entity;

import java.util.Date;

public class Reply {
    Integer rid;
    Integer uid;
    Integer cid;
    String context;
    Date rtime;

    public Reply() {
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "rid=" + rid +
                ", uid=" + uid +
                ", cid=" + cid +
                ", context='" + context + '\'' +
                ", rtime=" + rtime +
                '}';
    }
}
