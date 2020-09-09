package com.entity;

import java.util.Date;

public class Orders {
    Integer oid;
    Integer Order_num;
    String state;
    Integer uid;
    Date createtime;
    Double order_price;
    String bnbname;

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

    public void setState(String state) {
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



    public Double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Double order_price) {
        this.order_price = order_price;
    }


    public String getBnbname() {
        return bnbname;
    }

    public void setBnbname(String bnbname) {
        this.bnbname = bnbname;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid=" + oid +
                ", Order_num=" + Order_num +
                ", state='" + state + '\'' +
                ", uid=" + uid +
                ", createtime=" + createtime +
                ", order_price=" + order_price +
                ", bnbname='" + bnbname + '\'' +
                '}';
    }
}
