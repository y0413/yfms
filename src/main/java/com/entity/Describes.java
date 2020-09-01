package com.entity;

import javax.persistence.Id;

public class Describes {

    @Id
    Integer did;
    String title;
    String desbes;
    String internal;
    String traffic;
    String spots;
    String requirement;//对房客的要求

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Describes() {
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesbes() {
        return desbes;
    }

    public void setDesbes(String desbes) {
        this.desbes = desbes;
    }

    public String getInternal() {
        return internal;
    }

    public void setInternal(String internal) {
        this.internal = internal;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getSpots() {
        return spots;
    }

    public void setSpots(String spots) {
        this.spots = spots;
    }

    @Override
    public String toString() {
        return "Describes{" +
                "did=" + did +
                ", title='" + title + '\'' +
                ", desbes='" + desbes + '\'' +
                ", internal='" + internal + '\'' +
                ", traffic='" + traffic + '\'' +
                ", spots='" + spots + '\'' +
                '}';
    }
}
