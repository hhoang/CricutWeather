package com.hhoang.cricutweather;

import android.app.Application;
import com.hhoang.cricutweather.dagger.AppModule;
import com.hhoang.cricutweather.dagger.DaggerWeatherComponent;
import com.hhoang.cricutweather.dagger.WeatherComponent;
import com.hhoang.cricutweather.dagger.WeatherModule;

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