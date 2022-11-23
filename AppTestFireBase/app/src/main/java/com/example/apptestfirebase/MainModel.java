package com.example.apptestfirebase;

public class MainModel {
    private String name, dir, price, turl;

    MainModel() {

    }
    public MainModel(String name, String email, String course, String turl) {
        this.name = name;
        this.dir = email;
        this.price = course;
        this.turl = turl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return dir;
    }

    public void setEmail(String email) {
        this.dir = email;
    }

    public String getCourse() {
        return price;
    }

    public void setCourse(String course) {
        this.price = course;
    }

    public String getTurl() {
        return turl;
    }

    public void setTurl(String turl) {
        this.turl = turl;
    }
}
