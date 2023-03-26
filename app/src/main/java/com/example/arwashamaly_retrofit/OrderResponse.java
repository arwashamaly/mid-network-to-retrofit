package com.example.arwashamaly_retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OrderResponse {
    @SerializedName("code")
    int code;
    @SerializedName("data")
    ArrayList<Order> dataArrayList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ArrayList<Order> getDataArrayList() {
        return dataArrayList;
    }

    public void setDataArrayList(ArrayList<Order> dataArrayList) {
        this.dataArrayList = dataArrayList;
    }
}
class Order{
    @SerializedName("phone")
    String phone;
    @SerializedName("details")
    String details ;
    @SerializedName("photo_order")
    ArrayList<Photo> photo_order;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public ArrayList<Photo> getPhoto_order() {
        return photo_order;
    }

    public void setPhoto_order(ArrayList<Photo> photo_order) {
        this.photo_order = photo_order;
    }
}
class Photo{
    @SerializedName("photo")
    String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

