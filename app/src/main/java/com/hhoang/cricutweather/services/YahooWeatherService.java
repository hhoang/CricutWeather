package com.hhoang.cricutweather.services;

import com.hhoang.cricutweather.models.YahooWeatherQuery;
import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by hoahoang on 4/3/17.
 */

public interface YahooWeatherService {
  @GET("yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D\"Salt%20Lake%20City%2C%20UT\")&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
  Single<YahooWeatherQuery> getWeather();
}
