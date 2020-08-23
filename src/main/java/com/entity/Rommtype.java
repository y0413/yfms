package com.entity;

public class Rommtype {
    Integer rid;
    String rname;
    String notes;

    public Rommtype() {
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Rommtype{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
