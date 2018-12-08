package com.example.gpo;

public class Mapscl {

    int id;
    String number;
    String time;
    String opis;
    public Mapscl(){
    }

    public Mapscl(int id, String number, String time, String opis){
        this.id = id;
        this.number = number;
        this.time = time;
        this.opis = opis;
    }

    public Mapscl(String number, String time, String opis){
        this.number = number;
        this.time = time;
        this.opis = opis;
    }

    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getNumber(){
        return this.number;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public String getTime(){
        return this.time;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getOpis(){return this.opis;}

    public void setOpis(String opis){
        this.opis = opis;
    }
}
