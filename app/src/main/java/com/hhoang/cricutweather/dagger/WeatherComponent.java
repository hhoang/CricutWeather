package com.hhoang.cricutweather.dagger;

import com.hhoang.cricutweather.ui.activities.Home;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by hoahoang on 4/3/17.
 */

@Singleton
@Component(modules = {AppModule.class, WeatherModule.class})
public interface WeatherComponent {
  void inject(Home activity);
}
