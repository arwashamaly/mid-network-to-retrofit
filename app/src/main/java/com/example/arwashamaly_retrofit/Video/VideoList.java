package com.example.arwashamaly_retrofit.Video;

import static com.example.arwashamaly_retrofit.MainActivity.sharedToken;
import static com.example.arwashamaly_retrofit.MainActivity.sharedTokenKey;
import static com.example.arwashamaly_retrofit.Video.LoginVideo.sharedToken2;
import static com.example.arwashamaly_retrofit.Video.LoginVideo.sharedTokenKey2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.arwashamaly_retrofit.OrderAdapter;
import com.example.arwashamaly_retrofit.databinding.ActivityLoginVideoBinding;
import com.example.arwashamaly_retrofit.databinding.ActivityVideoListBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoList extends AppCompatActivity {
ActivityVideoListBinding binding;
    ApiServiceVideo serviceVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityVideoListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        serviceVideo = ApiServiceVideo.RetrofitClassVideo.getRetrofitInstanceVideo();

        getVideo();
    }

    private void getVideo() {
        String token =  sharedToken2.getString(sharedTokenKey2,"");

        serviceVideo.getVideos(1,token).enqueue(new Callback<VideoListResponse>() {
            @Override
            public void onResponse(Call<VideoListResponse> call, Response<VideoListResponse> response) {
                ArrayList<Video> data =response.body().getData();

                VideoAdapter adapter =new VideoAdapter(data,getBaseContext());
                binding.res.setAdapter(adapter);
                binding.res.setLayoutManager(new LinearLayoutManager(getBaseContext(),
                        RecyclerView.VERTICAL,false));

            }

            @Override
            public void onFailure(Call<VideoListResponse> call, Throwable t) {

            }
        });
    }
}