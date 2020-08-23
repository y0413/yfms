package com.entity;

public class Posi_tion {
    Integer pid;
    String pname;

    public Posi_tion() {
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "Posi_tion{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                '}';
    }
}
