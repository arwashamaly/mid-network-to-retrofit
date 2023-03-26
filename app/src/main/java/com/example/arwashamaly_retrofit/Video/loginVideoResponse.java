package com.example.arwashamaly_retrofit.Video;

import com.google.gson.annotations.SerializedName;

public class loginVideoResponse {
    @SerializedName("token")
    String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
