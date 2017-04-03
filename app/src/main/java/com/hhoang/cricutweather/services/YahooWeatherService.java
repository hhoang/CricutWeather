package com.hhoang.cricutweather.services;

import com.hhoang.cricutweather.models.YahooWeatherQuery;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hoahoang on 4/3/17.
 */

public interface YahooWeatherService {

  public static final Retrofit api =
      new Retrofit.Builder().baseUrl("https://query.yahooapis.com/v1/public/")
          .addConverterFactory(GsonConverterFactory.create())
          .build();

  @GET("yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D\"Salt%20Lake%20City%2C%20UT\")&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
  Call<YahooWeatherQuery> getWeather();
}
