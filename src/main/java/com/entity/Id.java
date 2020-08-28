package com.entity;

public class Id {
    Integer bnbid;
    Integer rid;
    Integer liva_id;
    Integer did;

    public Id() {
    }

    public Integer getBnbid() {
        return bnbid;
    }

    public void setBnbid(Integer bnbid) {
        this.bnbid = bnbid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getLiva_id() {
        return liva_id;
    }

    public void setLiva_id(Integer liva_id) {
        this.liva_id = liva_id;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "Id{" +
                "bnbid=" + bnbid +
                ", rid=" + rid +
                ", liva_id=" + liva_id +
                ", did=" + did +
                '}';
    }
}
