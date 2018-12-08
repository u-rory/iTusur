package com.example.gpo.Data;

import java.util.ArrayList;
import java.util.List;

public class DataMaps {
    int id;
    String name;
    String opisanie;
    int photoId;
    public DataMaps(){}

    public DataMaps(int id, String name, String opisanie,  int photoId){
        this.id = id;
        this.name = name;
        this.opisanie = opisanie;
        this.photoId = photoId;
    }
    public DataMaps(String name, String opisanie, int photoId) {
        this.name = name;
        this.opisanie = opisanie;
        this.photoId = photoId;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String text) {this.name = name;}
    public String getOpisanie() {
        return this.opisanie;
    }
    public void setOpisanie(String opisanie) {this.opisanie = opisanie;}
    public int getPhotoId(){
        return this.photoId;
    }
    public void setPhotoId(int photoId){
        this.photoId = photoId;
    }
    public int getID(){
        return this.id;
    }
    public void setID(int id){
        this.id = id;
    }
}