package com.entity;

import java.util.Date;

public class Feedback {
    Integer fid;
    Integer uid;
    Integer bnbid;
    Date ftime;
    String fcontext;
    String state;

    public Feedback() {
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
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

    public Date getFtime() {
        return ftime;
    }

    public void setFtime(Date ftime) {
        this.ftime = ftime;
    }

    public String getFcontext() {
        return fcontext;
    }

    public void setFcontext(String fcontext) {
        this.fcontext = fcontext;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "fid=" + fid +
                ", uid=" + uid +
                ", bnbid=" + bnbid +
                ", ftime=" + ftime +
                ", fcontext='" + fcontext + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
