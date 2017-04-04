package com.hhoang.cricutweather.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hhoang.cricutweather.R;
import com.hhoang.cricutweather.models.YahooWeatherQuery;

/**
 * Created by hoahoang on 4/3/17.
 */

public class ForecastFragment extends Fragment {

  private YahooWeatherQuery weatherData;
  public ForecastFragment() {}

  public static ForecastFragment newInstance(YahooWeatherQuery weatherData) {
    ForecastFragment fragment = new ForecastFragment();
    Bundle args = new Bundle();
    args.putParcelable("data", weatherData);
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      weatherData = getArguments().getParcelable("data");
    }
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_forecast, container, false);
  }
}
