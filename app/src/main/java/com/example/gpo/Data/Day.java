package com.example.gpo.Data;

public class Day {

    int id;
    String predmet;
    String type;
    String aud;
    String prepod;
    public Day(){
    }

    public Day(int id, String predmet, String type, String aud, String teach){
        this.id = id;
        this.predmet = predmet;
        this.type = type;
        this.aud = aud;
        this.prepod = teach;
    }

    public Day(String predmet, String type, String aud, String teach){
        this.predmet = predmet;
        this.type = type;
        this.aud = aud;
        this.prepod = teach;
    }

    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getPredmet(){
        return this.predmet;
    }

    public void setPredmet(String predmet){
        this.predmet = predmet;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getAud(){
        return this.aud;
    }

    public void setAud(String aud){
        this.aud = aud;
    }

    public String getPrepod(){
        return this.prepod;
    }

    public void setPrepod(String teach){
        this.prepod = teach;
    }

}
