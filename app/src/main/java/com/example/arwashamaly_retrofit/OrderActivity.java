package com.example.arwashamaly_retrofit;

import static com.example.arwashamaly_retrofit.MainActivity.editToken;
import static com.example.arwashamaly_retrofit.MainActivity.sharedToken;
import static com.example.arwashamaly_retrofit.MainActivity.sharedTokenKey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.arwashamaly_retrofit.databinding.ActivityOrderBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;
    ApiService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        service =  ApiService.RetrofitClass.getRetrofitInstance();

        getOrder();

        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();
            }
        });
    }

    private void logOut() {

        String token = "Bearer "+sharedToken.getString(sharedTokenKey,"");

        service.logOut(token).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                editToken.clear();
                editToken.commit();
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void getOrder() {
        String token = "Bearer "+sharedToken.getString(sharedTokenKey,"");

        service.getOrder(token).enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                ArrayList<Order> arrayList=response.body().getDataArrayList();

                OrderAdapter adapter =new OrderAdapter(arrayList,getBaseContext());
                binding.rc.setAdapter(adapter);
                binding.rc.setLayoutManager(new LinearLayoutManager(getBaseContext(),
                        RecyclerView.VERTICAL,false));

            }

            @Override
            public void onFailure(Call<OrderResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}