package com.entity;

import java.util.Date;

public class Water {
    Integer wid;
    Float wmoney;
    Integer state;
    Integer uid;
    Date createtime;
    Integer wstate;

    public Water() {
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Float getWmoney() {
        return wmoney;
    }

    public void setWmoney(Float wmoney) {
        this.wmoney = wmoney;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getWstate() {
        return wstate;
    }

    public void setWstate(Integer wstate) {
        this.wstate = wstate;
    }

    @Override
    public String toString() {
        return "Water{" +
                "wid=" + wid +
                ", wmoney=" + wmoney +
                ", state=" + state +
                ", uid=" + uid +
                ", createtime=" + createtime +
                ", wstate=" + wstate +
                '}';
    }
}
