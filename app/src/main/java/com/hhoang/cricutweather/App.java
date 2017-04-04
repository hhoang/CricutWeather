package com.hhoang.cricutweather;

import android.app.Application;
import com.hhoang.cricutweather.Dagger.AppModule;
import com.hhoang.cricutweather.Dagger.DaggerWeatherComponent;
import com.hhoang.cricutweather.Dagger.WeatherComponent;
import com.hhoang.cricutweather.Dagger.WeatherModule;

/**
 * Created by hoahoang on 4/3/17.
 */

public class App extends Application {

  private WeatherComponent weatherComponent;

  @Override
  public void onCreate() {
    super.onCreate();


    weatherComponent = DaggerWeatherComponent.builder()
        .appModule(new AppModule(this))
        .weatherModule(new WeatherModule())
        .build();
  }

  public WeatherComponent getWeatherComponent() {
    return weatherComponent;
  }
}