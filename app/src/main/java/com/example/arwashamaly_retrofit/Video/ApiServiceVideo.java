package com.example.arwashamaly_retrofit.Video;

import com.example.arwashamaly_retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServiceVideo {
    @POST("Auth/login")
    @FormUrlEncoded
    Call<loginVideoResponse> loginVideo(
            @Field("os") String os,
            @Field("version") String version,
            @Field("username") String username,
            @Field("password") String password,
            @Field("user_type") String user_type,
            @Field("os_version") String os_version,
            @Field("device_token") String device_token,
            @Field("device_id") String device_id
            );
    @GET("Video/videosList?")
    Call<VideoListResponse> getVideos(@Query("category_id") int id, @Header("token") String token);


    class RetrofitClassVideo {
        public static String BASE_URL = "https://stgapiphp7.ireadarabic.com/en/";

        public static ApiServiceVideo getRetrofitInstanceVideo(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(ApiServiceVideo.class);
        }
    }
}
