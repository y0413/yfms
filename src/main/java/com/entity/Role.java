package com.entity;

public class Role {
    Integer auth_id;
    Integer pid;

    public Role() {
    }

    public Integer getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(Integer auth_id) {
        this.auth_id = auth_id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Role{" +
                "auth_id=" + auth_id +
                ", pid=" + pid +
                '}';
    }
}
