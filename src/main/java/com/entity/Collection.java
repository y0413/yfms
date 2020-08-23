package com.entity;

public class Collection {
    Integer cid;
    Integer uid;
    Integer bnbid;

    public Collection() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBnbid() {
        return bnbid;
    }

    public void setBnbid(Integer bnbid) {
        this.bnbid = bnbid;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", bnbid=" + bnbid +
                '}';
    }
}
