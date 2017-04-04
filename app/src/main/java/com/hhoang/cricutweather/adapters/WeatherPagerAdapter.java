package com.hhoang.cricutweather.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.hhoang.cricutweather.ui.fragments.CurrentFragment;
import com.hhoang.cricutweather.ui.fragments.ForecastFragment;
import com.hhoang.cricutweather.models.YahooWeatherQuery;

/**
 * Created by hoahoang on 4/3/17.
 */

public class WeatherPagerAdapter extends FragmentPagerAdapter {

  private YahooWeatherQuery weatherData;

  public WeatherPagerAdapter(FragmentManager fm, YahooWeatherQuery weatherData) {
    super(fm);
    this.weatherData = weatherData;
  }

  @Override public Fragment getItem(int position) {

    switch (position) {
      case 0:
        return CurrentFragment.newInstance(weatherData);
      case 1:
        return ForecastFragment.newInstance(weatherData);
      default:
        return null;
    }
  }

  @Override public int getCount() {
    // Show 3 total pages.
    return 2;
  }

  @Override public CharSequence getPageTitle(int position) {
    switch (position) {
      case 0:
        return "Current";
      case 1:
        return "Forecast";
    }
    return null;
  }
}
