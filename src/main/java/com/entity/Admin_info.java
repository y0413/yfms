package com.entity;

public class Admin_info {
    Integer aiId;
    String aname;
    String asex;
    String atel;
    String address;
    String idcard;
    Integer state;
    Integer pid;

    public Admin_info() {
    }

    public Integer getAiId() {
        return aiId;
    }

    public void setAiId(Integer aiId) {
        this.aiId = aiId;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAsex() {
        return asex;
    }

    public void setAsex(String asex) {
        this.asex = asex;
    }

    public String getAtel() {
        return atel;
    }

    public void setAtel(String atel) {
        this.atel = atel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Admin_info{" +
                "aiId=" + aiId +
                ", aname='" + aname + '\'' +
                ", asex='" + asex + '\'' +
                ", atel='" + atel + '\'' +
                ", address='" + address + '\'' +
                ", idcard='" + idcard + '\'' +
                ", state=" + state +
                ", pid=" + pid +
                '}';
    }
}
