package com.entity;

public class Describes {
    Integer did;
    String title;
    String describes;
    String Internal;
    String Traffic;
    String spots;

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

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getInternal() {
        return Internal;
    }

    public void setInternal(String internal) {
        Internal = internal;
    }

    public String getTraffic() {
        return Traffic;
    }

    public void setTraffic(String traffic) {
        Traffic = traffic;
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
                ", describes='" + describes + '\'' +
                ", Internal='" + Internal + '\'' +
                ", Traffic='" + Traffic + '\'' +
                ", spots='" + spots + '\'' +
                '}';
    }
}
