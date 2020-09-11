package com.entity;

import java.util.Date;

public class Orders {
    Integer oid;
    Integer Order_num;
    String state;
    String bnbname;
    Integer bnbid;
    Integer uid;
    Date createtime;
    String order_notes;
    Double order_price;
    Date sendtime;
    Date starttime;
    Integer bnbid;

    public Integer getBnbid() {
        return bnbid;
    }

    public void setBnbid(Integer bnbid) {
        this.bnbid = bnbid;
    }

    public Orders() {
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getOrder_num() {
        return Order_num;
    }

    public void setOrder_num(Integer order_num) {
        Order_num = order_num;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid=" + oid +
                ", Order_num=" + Order_num +
                ", state='" + state + '\'' +
                ", bnbname='" + bnbname + '\'' +
                ", uid=" + uid +
                ", createtime=" + createtime +
                ", order_price=" + order_price +
                ", sendtime=" + sendtime +
                ", starttime=" + starttime +
                '}';
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBnbname() {
        return bnbname;
    }

    public void setBnbname(String bnbname) {
        this.bnbname = bnbname;
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

    public Double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Double order_price) {
        this.order_price = order_price;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

}
