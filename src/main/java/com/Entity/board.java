package com.Entity;

public class board {
    private String bid;
    private String bname;

    @Override
    public String toString() {
        return "board{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                '}';
    }


    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
}
