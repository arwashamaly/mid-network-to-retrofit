package com.example.arwashamaly_retrofit.Video;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VideoListResponse {
    @SerializedName("data")
    ArrayList<Video> data;

    public ArrayList<Video> getData() {
        return data;
    }

    public void setData(ArrayList<Video> data) {
        this.data = data;
    }
}
class Video{
    @SerializedName("video_id")
    String video_id;
    @SerializedName("discription")
    String discription;
    @SerializedName("video_cover_image")
    String video_cover_image;

    public Video(String video_id, String discription, String video_cover_image) {
        this.video_id = video_id;
        this.discription = discription;
        this.video_cover_image = video_cover_image;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getVideo_cover_image() {
        return video_cover_image;
    }

    public void setVideo_cover_image(String video_cover_image) {
        this.video_cover_image = video_cover_image;
    }
}
