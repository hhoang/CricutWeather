package com.hhoang.cricutweather.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hhoang.cricutweather.R;
import com.hhoang.cricutweather.fragments.CurrentFragment;
import com.hhoang.cricutweather.fragments.DetailFragment;
import com.hhoang.cricutweather.fragments.ForecastFragment;
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
      case 2:
        return DetailFragment.newInstance(weatherData);
      default:
        return null;
    }
  }

  @Override public int getCount() {
    // Show 3 total pages.
    return 3;
  }

  @Override public CharSequence getPageTitle(int position) {
    switch (position) {
      case 0:
        return "Current";
      case 1:
        return "Forecast";
      case 2:
        return "Details";
    }
    return null;
  }
}
