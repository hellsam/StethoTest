package com.hellsam.stethotest.net;

import com.hellsam.stethotest.db.model.response.CommonObjectResponse;
import com.hellsam.stethotest.db.model.response.Weather;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by binshenchen on 16/3/2.
 */
public interface WeatherApi {

    @Headers({"apikey:dfd10cc8bddc85581d56121a3f93dcfd"})
    @GET("apistore/weatherservice/cityname")
    Call<CommonObjectResponse<Weather>> getWeather(@Query("cityname") String cityName);
}
