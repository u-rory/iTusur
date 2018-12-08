package com.example.gpo.Data;

public class DataModel {
    int id;
   String text;
  String date;
    String name;
    String images;
    public DataModel(){}

    public DataModel(int id, String text, String date, String name, String images){
        this.id = id;
        this.text = text;
        this.date = date;
        this.name = name;
        this.images = images;

    }
    public DataModel(String text, String date, String name, String images) {
        this.text = text;
        this.date = date;
        this.name = name;
        this.images = images;
    }

    public String getName() {
        return this.text;
    }
    public void setName(String text) {this.text = text;}
    public String getVersion() {
        return this.date;
    }
    public void setVersion(String date) {this.date = date;}
    public int getID(){
        return this.id;
    }
    public void setID(int id){
        this.id = id;
    }

    public String getName2() {
        return this.name;
    }
    public void setName2(String name) {this.name = name;}
    public String getImages() {
        return this.images;
    }
    public void setImages(String date) {this.images = images;}
}
