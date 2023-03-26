package com.example.arwashamaly_retrofit;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {

    @POST("auth/login/user")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET("order/un/complete/user")
    Call<OrderResponse> getOrder(@Header("Authorization") String Authorization);

    @GET("auth/logout")
    Call<Void> logOut(@Header("Authorization") String Authorization);

    class RetrofitClass {
        public static String BASE_URL = "https://studentucas.awamr.com/api/";

        public static ApiService getRetrofitInstance(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(ApiService.class);
        }
    }

}
