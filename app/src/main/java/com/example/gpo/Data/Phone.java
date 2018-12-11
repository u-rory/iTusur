package com.example.gpo.Data;

public class Phone {

    public String name;
    public String company;
    public String aud;
    public String prepod;
    public String time;


    public Phone(String name, String company, String aud,String prepod,String time){

        this.name=name;
        this.company = company;
        this.aud=aud;
        this.prepod = prepod;
        this.time=time;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAudd() {
        return this.aud;
    }

    public void setAudd(String aud) {
        this.aud = aud;
    }
    public String getPrepodd() {
        return this.prepod;
    }

    public void setPrepodd(String prepod) {this.aud = prepod;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}