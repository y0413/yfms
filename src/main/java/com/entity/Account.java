package com.entity;

public class Account {
    Integer aid;
    String acc;
    String idcard;
    Integer uid;

    public Account() {
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", acc='" + acc + '\'' +
                ", idcard='" + idcard + '\'' +
                ", uid=" + uid +
                '}';
    }
}
