package com.entity;

import java.util.Date;

public class Orders {
    Integer oid;
    String Order_num;
    String state;
    Integer bnbid;
    Integer uid;
    Date createtime;
    String order_notes;
    Double order_price;
    Integer order_people;

    public Orders() {
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOrder_num() {
        return Order_num;
    }

    public void setOrder_num(String order_num) {
        Order_num = order_num;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getBnbid() {
        return bnbid;
    }

    public void setBnbid(Integer bnbid) {
        this.bnbid = bnbid;
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

    public String getOrder_notes() {
        return order_notes;
    }

    public void setOrder_notes(String order_notes) {
        this.order_notes = order_notes;
    }

    public Double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Double order_price) {
        this.order_price = order_price;
    }

    public Integer getOrder_people() {
        return order_people;
    }

    public void setOrder_people(Integer order_people) {
        this.order_people = order_people;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid=" + oid +
                ", Order_num='" + Order_num + '\'' +
                ", state='" + state + '\'' +
                ", bnbid=" + bnbid +
                ", uid=" + uid +
                ", createtime=" + createtime +
                ", order_notes='" + order_notes + '\'' +
                ", order_price=" + order_price +
                ", order_people=" + order_people +
                '}';
    }
}
