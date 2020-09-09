package com.entity;

public class Platform {
    Float pmoney;

    public Float getPmoney() {
        return pmoney;
    }

    public void setPmoney(Float pmoney) {
        this.pmoney = pmoney;
    }

    @Override
    public String toString() {
        return "Platform{" +
                "pmoney=" + pmoney +
                '}';
    }

    public Platform() {
    }
}
