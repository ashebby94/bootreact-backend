package com.bootreact.backend.mvc.entity;

public class Computer {

    private int id;
    private String name;
    private String ip;
    private String mac;
    private String location;
    private String date;

    public Computer(int id, String name, String ip, String mac, String location, String date) {
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.mac = mac;
        this.location = location;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
