package com.entity;

public class Livable {
    Integer liva_id;
    Integer liva_num;
    String lnotes;

    public Livable() {
    }

    public Integer getLiva_id() {
        return liva_id;
    }

    public void setLiva_id(Integer liva_id) {
        this.liva_id = liva_id;
    }

    public Integer getLiva_num() {
        return liva_num;
    }

    public void setLiva_num(Integer liva_num) {
        this.liva_num = liva_num;
    }

    public String getLnotes() {
        return lnotes;
    }

    public void setLnotes(String lnotes) {
        this.lnotes = lnotes;
    }

    @Override
    public String toString() {
        return "Livable{" +
                "liva_id=" + liva_id +
                ", liva_num=" + liva_num +
                ", lnotes='" + lnotes + '\'' +
                '}';
    }
}
