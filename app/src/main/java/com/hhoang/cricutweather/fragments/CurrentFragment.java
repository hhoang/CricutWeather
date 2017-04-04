package com.hhoang.cricutweather.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.hhoang.cricutweather.R;
import com.hhoang.cricutweather.models.YahooWeatherQuery;
import com.squareup.picasso.Picasso;
import java.text.Format;

/**
 * Created by hoahoang on 4/3/17.
 */

public class CurrentFragment extends Fragment {
  private YahooWeatherQuery weatherData;
  @BindView(R.id.description) TextView description;
  @BindView(R.id.image) ImageView image;
  @BindView(R.id.date) TextView date;
  @BindView(R.id.temp) TextView temp;
  @BindView(R.id.high_text) TextView tempLow;
  @BindView(R.id.low_text) TextView tempHigh;

  public static CurrentFragment newInstance(YahooWeatherQuery weatherData) {
    CurrentFragment fragment = new CurrentFragment();
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
    View view = inflater.inflate(R.layout.fragment_current, container, false);
    ButterKnife.bind(this, view);
    description.setText(weatherData.getCondition().text);
    date.setText(weatherData.getCondition().date);
    tempLow.setText(weatherData.getCurrentForecast().low);
    tempHigh.setText(weatherData.getCurrentForecast().high);
    temp.setText(String.format(getString(R.string.temperature), weatherData.getCondition().temp));

    Picasso.with(getContext()).load(String.format(getString(R.string.image_url), weatherData.getCondition().code)).into(image);

    return view;
  }
}
