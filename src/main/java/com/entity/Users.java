package com.entity;

import java.util.Date;

public class Users {
    Integer uid;
    String photo;
    String uname;
    String upwd;
    String usex;
    String email;
    String address;
    Date createtime;
    String state;
    String truename;
    String idcard;
    Integer bnbid;
    Integer ustate;

    public Users() {
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }


    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Integer getBnbid() {
        return bnbid;
    }

    public void setBnbid(Integer bnbid) {
        this.bnbid = bnbid;
    }

    public Integer getUstate() {
        return ustate;
    }

    public void setUstate(Integer ustate) {
        this.ustate = ustate;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", photo='" + photo + '\'' +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", usex='" + usex + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", createtime=" + createtime +
                ", state='" + state + '\'' +
                ", truename='" + truename + '\'' +
                ", idcard='" + idcard + '\'' +
                ", bnbid=" + bnbid +
                ", ustate=" + ustate +
                '}';
    }
}
