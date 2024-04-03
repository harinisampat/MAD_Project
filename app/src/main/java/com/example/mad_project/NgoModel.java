package com.example.mad_project;
import java.*;
import java.util.ArrayList;
import java.util.List;

import android.*;

public class NgoModel {
    private int imageid;
    private String title, type, location, phone, website;

    public NgoModel(String title, int imageid, String type, String location, String phone, String website){
        this.title = title;
        this.imageid = imageid;
        this.type = type;
        this.location = location;
        this.phone = phone;
        this.website = website;
    }

    public NgoModel() {

    }

    public int getImageid(){
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType(){
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite(){
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public static List<NgoModel> getObjectList(){
        List<NgoModel> datalist = new ArrayList<>();
        int[] images=getImages();
        for (int i=0;i<images.length;i++){
            NgoModel ngo = new NgoModel();
            ngo.setImageid(images[i]);
            ngo.setTitle("" + i);
            ngo.setType("" + i);
            ngo.setLocation("" + i);
            ngo.setPhone("" + i);
            ngo.setWebsite("" + i);
            datalist.add(ngo);
        }
        return datalist;
    }

    private static int[] getImages(){
        int[] images={R.drawable.udaan, R.drawable.punarvas, R.drawable.yuva, R.drawable.smile, R.drawable.bhn, R.drawable.stanthony, R.drawable.helpyourngo, R.drawable.vconnect};
        return images;
    }
}
