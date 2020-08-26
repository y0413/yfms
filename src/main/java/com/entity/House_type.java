package com.entity;

public class House_type {
    Integer hid;
    String hname;
    String notes;
    Integer bnbid;

    public House_type() {
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getBnbid() {
        return bnbid;
    }

    public void setBnbid(Integer bnbid) {
        this.bnbid = bnbid;
    }

    @Override
    public String toString() {
        return "House_typeDao{" +
                "hid=" + hid +
                ", hname='" + hname + '\'' +
                ", notes='" + notes + '\'' +
                ", bnbid=" + bnbid +
                '}';
    }
}
