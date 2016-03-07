package com.hellsam.stethotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.hellsam.stethotest.db.UserDAO;
import com.hellsam.stethotest.db.model.response.CommonObjectResponse;
import com.hellsam.stethotest.db.model.response.Weather;
import com.hellsam.stethotest.net.ApiManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDAO.getInstance().saveUser("13222222222", "hellsam");
            }
        });

        findViewById(R.id.btn_get_weather).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiManager.getInstance().getTestApi().getWeather("杭州").enqueue(new Callback<CommonObjectResponse<Weather>>() {
                    @Override
                    public void onResponse(Call<CommonObjectResponse<Weather>> call, Response<CommonObjectResponse<Weather>> response) {
                        Log.i("TAG", JSON.toJSONString(response.body()));
                    }

                    @Override
                    public void onFailure(Call<CommonObjectResponse<Weather>> call, Throwable t) {
                        Log.e("TAG", t.getMessage());
                    }
                });
            }
        });
    }
}
