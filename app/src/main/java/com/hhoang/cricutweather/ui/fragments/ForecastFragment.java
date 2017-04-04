package com.hhoang.cricutweather.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.hhoang.cricutweather.R;
import com.hhoang.cricutweather.adapters.ForecastRecyclerAdapter;
import com.hhoang.cricutweather.models.YahooWeatherQuery;

/**
 * Created by hoahoang on 4/3/17.
 */

public class ForecastFragment extends Fragment {

  private YahooWeatherQuery weatherData;
  private ForecastRecyclerAdapter adapter;
  @BindView(R.id.recycler) RecyclerView recyclerView;

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
      adapter = new ForecastRecyclerAdapter(getActivity(), weatherData.getForecasts());
    }
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_forecast, container, false);
    ButterKnife.bind(this, view);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    return view;
  }
}
