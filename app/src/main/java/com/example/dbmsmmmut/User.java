package com.example.dbmsmmmut;

public class User {

    String mode;
    String sender;
    String reciever;
    String address;
    String ddate;
    String adate;
    String veh;
    String supply;

    User(){

    }

    public User(String mode, String sender, String reciever, String address, String ddate, String adate, String veh, String supply) {
        this.mode = mode;
        this.sender = sender;
        this.reciever = reciever;
        this.address = address;
        this.ddate = ddate;
        this.adate = adate;
        this.veh = veh;
        this.supply = supply;
    }

    public String getMode() {
        return mode;
    }

    public String getSender() {
        return sender;
    }

    public String getReciever() {
        return reciever;
    }

    public String getAddress() {
        return address;
    }

    public String getDdate() {
        return ddate;
    }

    public String getAdate() {
        return adate;
    }

    public String getVeh() {
        return veh;
    }

    public String getSupply() {
        return supply;
    }
}



