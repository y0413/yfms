package com.entity;

public class Authority {
    Integer auth_id;
    String auth_name;
    String auth_Url;
    Integer auth_Pid;

    public Authority() {
    }

    public Integer getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(Integer auth_id) {
        this.auth_id = auth_id;
    }

    public String getAuth_name() {
        return auth_name;
    }

    public void setAuth_name(String auth_name) {
        this.auth_name = auth_name;
    }

    public String getAuth_Url() {
        return auth_Url;
    }

    public void setAuth_Url(String auth_Url) {
        this.auth_Url = auth_Url;
    }

    public Integer getAuth_Pid() {
        return auth_Pid;
    }

    public void setAuth_Pid(Integer auth_Pid) {
        this.auth_Pid = auth_Pid;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "auth_id=" + auth_id +
                ", auth_name='" + auth_name + '\'' +
                ", auth_Url='" + auth_Url + '\'' +
                ", auth_Pid=" + auth_Pid +
                '}';
    }
}
