package com.entity;

import java.util.Date;

public class Admins {
    Integer aid;
    String account;
    String apwd;
    Integer astate;
    Date alogintime;
    String avatar;

    public Admins() {
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    public Integer getAstate() {
        return astate;
    }

    public void setAstate(Integer astate) {
        this.astate = astate;
    }

    public Date getAlogintime() {
        return alogintime;
    }

    public void setAlogintime(Date alogintime) {
        this.alogintime = alogintime;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Admins{" +
                "aid=" + aid +
                ", account='" + account + '\'' +
                ", apwd='" + apwd + '\'' +
                ", astate=" + astate +
                ", alogintime=" + alogintime +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
