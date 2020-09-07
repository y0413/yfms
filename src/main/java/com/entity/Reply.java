package com.entity;

import java.util.Date;

public class Reply {
    Integer rid;
    Integer uid;
    Integer cid;
    String context;
    Date rtime;
    Integer reply_person;
    String huifu_person;
    String pinglun_person;

    public String getHuifu_person() {
        return huifu_person;
    }

    public void setHuifu_person(String huifu_person) {
        this.huifu_person = huifu_person;
    }

    public String getPinglun_person() {
        return pinglun_person;
    }

    public void setPinglun_person(String pinglun_person) {
        this.pinglun_person = pinglun_person;
    }

    public Reply() {
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    public Integer getReply_person() {
        return reply_person;
    }

    public void setReply_person(Integer reply_person) {
        this.reply_person = reply_person;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "rid=" + rid +
                ", uid=" + uid +
                ", cid=" + cid +
                ", context='" + context + '\'' +
                ", rtime=" + rtime +
                ", reply_person=" + reply_person +
                ", huifu_person='" + huifu_person + '\'' +
                ", pinglun_person='" + pinglun_person + '\'' +
                '}';
    }
}
