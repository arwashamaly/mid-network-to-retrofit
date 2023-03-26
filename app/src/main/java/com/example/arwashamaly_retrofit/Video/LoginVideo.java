package com.example.arwashamaly_retrofit.Video;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.arwashamaly_retrofit.OrderActivity;
import com.example.arwashamaly_retrofit.databinding.ActivityLoginVideoBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginVideo extends AppCompatActivity {
ActivityLoginVideoBinding binding;
ApiServiceVideo serviceVideo;
    public static SharedPreferences sharedToken2;
    public static SharedPreferences.Editor editToken2;
    public String failTokenName2 ="tokenShared";
    public static String sharedTokenKey2 = "token";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedToken2= getSharedPreferences(failTokenName2,MODE_PRIVATE);
        editToken2 = sharedToken2.edit();

        serviceVideo = ApiServiceVideo.RetrofitClassVideo.getRetrofitInstanceVideo();

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginVideo();
            }
        });
    }

    private void loginVideo() {

        serviceVideo.loginVideo("ANDROID","1.2","its1","1234", "student",
                "1.2","dasdsa","fsafasads").enqueue(new Callback<loginVideoResponse>() {
            @Override
            public void onResponse(Call<loginVideoResponse> call, Response<loginVideoResponse> response) {
                String  token =response.body().getToken();
                editToken2.putString(sharedTokenKey2,token);
                editToken2.commit();
                startActivity(new Intent(getBaseContext(), VideoList.class));
                finish();
            }

            @Override
            public void onFailure(Call<loginVideoResponse> call, Throwable t) {
t.printStackTrace();
            }
        });
    }
}