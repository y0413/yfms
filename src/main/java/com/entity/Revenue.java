package com.entity;

import java.util.Date;

public class Revenue {
    Integer re_id;
    String re_num;
    Integer uid;
    Integer bnbid;
    Date createtime;
    Double collection;
    Double Total_rent;
    String Payment_status;
    String Payment_time;
    String state;

    public Revenue() {
    }

    public Integer getRe_id() {
        return re_id;
    }

    public void setRe_id(Integer re_id) {
        this.re_id = re_id;
    }

    public String getRe_num() {
        return re_num;
    }

    public void setRe_num(String re_num) {
        this.re_num = re_num;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Double getCollection() {
        return collection;
    }

    public void setCollection(Double collection) {
        this.collection = collection;
    }

    public Double getTotal_rent() {
        return Total_rent;
    }

    public void setTotal_rent(Double total_rent) {
        Total_rent = total_rent;
    }

    public String getPayment_status() {
        return Payment_status;
    }

    public void setPayment_status(String payment_status) {
        Payment_status = payment_status;
    }

    public String getPayment_time() {
        return Payment_time;
    }

    public void setPayment_time(String payment_time) {
        Payment_time = payment_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Revenue{" +
                "re_id=" + re_id +
                ", re_num='" + re_num + '\'' +
                ", uid=" + uid +
                ", bnbid=" + bnbid +
                ", createtime=" + createtime +
                ", collection=" + collection +
                ", Total_rent=" + Total_rent +
                ", Payment_status='" + Payment_status + '\'' +
                ", Payment_time='" + Payment_time + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
