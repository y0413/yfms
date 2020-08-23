package com.entity;

public class Bnbinfo {
    Integer bnbid;
    String bnbname;
    String state;
    String province;
    String city;
    String town;
    String address;
    Integer rid;
    Integer liva_id;
    Integer fid;
    Integer hid;
    Integer did;
    String shower;
    String air;
    String Television;
    String network;
    String Heating;
    String guard;
    String bedroom;
    String room;
    String toilet;
    String kitchen;

    public Bnbinfo() {
    }

    public Integer getBnbid() {
        return bnbid;
    }

    public void setBnbid(Integer bnbid) {
        this.bnbid = bnbid;
    }

    public String getBnbname() {
        return bnbname;
    }

    public void setBnbname(String bnbname) {
        this.bnbname = bnbname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getLiva_id() {
        return liva_id;
    }

    public void setLiva_id(Integer liva_id) {
        this.liva_id = liva_id;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getShower() {
        return shower;
    }

    public void setShower(String shower) {
        this.shower = shower;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }

    public String getTelevision() {
        return Television;
    }

    public void setTelevision(String television) {
        Television = television;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getHeating() {
        return Heating;
    }

    public void setHeating(String heating) {
        Heating = heating;
    }

    public String getGuard() {
        return guard;
    }

    public void setGuard(String guard) {
        this.guard = guard;
    }

    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getToilet() {
        return toilet;
    }

    public void setToilet(String toilet) {
        this.toilet = toilet;
    }

    public String getKitchen() {
        return kitchen;
    }

    public void setKitchen(String kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public String toString() {
        return "Bnbinfo{" +
                "bnbid=" + bnbid +
                ", bnbname='" + bnbname + '\'' +
                ", state='" + state + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                ", address='" + address + '\'' +
                ", rid=" + rid +
                ", liva_id=" + liva_id +
                ", fid=" + fid +
                ", hid=" + hid +
                ", did=" + did +
                ", shower='" + shower + '\'' +
                ", air='" + air + '\'' +
                ", Television='" + Television + '\'' +
                ", network='" + network + '\'' +
                ", Heating='" + Heating + '\'' +
                ", guard='" + guard + '\'' +
                ", bedroom='" + bedroom + '\'' +
                ", room='" + room + '\'' +
                ", toilet='" + toilet + '\'' +
                ", kitchen='" + kitchen + '\'' +
                '}';
    }
}
