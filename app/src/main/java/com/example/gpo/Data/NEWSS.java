package com.example.gpo.Data;

public class NEWSS {

    int id;
    String text;
    String date;
    String link;
    String name;
    String images;
    public NEWSS(){
    }

    public NEWSS(int id, String text, String date, String link, String name, String images){
        this.id = id;
        this.text = text;
        this.date = date;
        this.link = link;
        this.name = name;
        this.images = images;
    }

    public NEWSS(String text, String date, String link, String name, String images){
        this.text = text;
        this.date = date;
        this.link = link;
        this.name = name;
        this.images = images;
    }

    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getText(){
        return this.text;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getDate(){
        return this.date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getLink(){
        return this.link;
    }

    public void setLink(String link){
        this.link = link;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getImages(){
        return this.images;
    }

    public void setImages(String images){
        this.images = images;
    }
}
