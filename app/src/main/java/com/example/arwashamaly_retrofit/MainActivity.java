package com.example.arwashamaly_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.arwashamaly_retrofit.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
ApiService service;
    public static SharedPreferences sharedToken;
    public static SharedPreferences.Editor editToken;
    public String failTokenName ="tokenShared";
    public static String sharedTokenKey = "token";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedToken= getSharedPreferences(failTokenName,MODE_PRIVATE);
        editToken = sharedToken.edit();

        service =  ApiService.RetrofitClass.getRetrofitInstance();

        if (!sharedToken.getString(sharedTokenKey,"").isEmpty()){
            Intent intent = new Intent(getBaseContext(),OrderActivity.class);
            startActivity(intent);
            finish();
        }

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });
    }

    private void Login() {
        String email =binding.etEmail.getText().toString();
        String pass =binding.etPass.getText().toString();
        if (email.isEmpty()){
            binding.etEmail.setError("enter your email");
        }else if (pass.isEmpty()){
            binding.etPass.setError("enter your password");
        }else{
            LoginRequest loginRequest = new LoginRequest(email,pass);

            service.login(loginRequest).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        Data data = response.body().getData();
                        String token =data.getToken();
                        editToken.putString(sharedTokenKey,token);
                        editToken.commit();
                        startActivity(new Intent(getBaseContext(),OrderActivity.class));
                        finish();
                    }
                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }
    }
}