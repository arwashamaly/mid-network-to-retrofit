package com.example.arwashamaly_retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

class LoginResponse {
    @SerializedName("data")
    Data data;
    public LoginResponse(Data data) {
        this.data = data;
    }
    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }
}
class Data{
    String token;
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}
