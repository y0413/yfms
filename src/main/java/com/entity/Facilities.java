package com.entity;

public class Facilities {
    Integer fid;
    String fname;
    String notes;

    public Facilities() {
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Facilities{" +
                "fid=" + fid +
                ", fname='" + fname + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
