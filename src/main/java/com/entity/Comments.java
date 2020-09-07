package com.entity;

import java.util.Date;

public class Comments {
    Integer cid;
    String context;
    Date ctime;
    Integer uid;
    Integer bnbid;
    String uname;

    public Comments() {
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
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
        return "Comments{" +
                "cid=" + cid +
                ", context='" + context + '\'' +
                ", ctime=" + ctime +
                ", uid=" + uid +
                ", bnbid=" + bnbid +
                ", uname='" + uname + '\'' +
                '}';
    }
}
