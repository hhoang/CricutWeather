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

public class DetailFragment extends Fragment {
  private YahooWeatherQuery weatherData;

  public DetailFragment() {
    // Required empty public constructor
  }

  public static DetailFragment newInstance(YahooWeatherQuery weatherData) {
    DetailFragment fragment = new DetailFragment();
    Bundle args = new Bundle();
    args.putParcelable("data", weatherData);
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      //mParam1 = getArguments().getString(ARG_PARAM1);
    }
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_current, container, false);
  }
}