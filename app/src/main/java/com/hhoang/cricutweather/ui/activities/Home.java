package com.hhoang.cricutweather.ui.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.hhoang.cricutweather.App;
import com.hhoang.cricutweather.R;
import com.hhoang.cricutweather.adapters.WeatherPagerAdapter;
import com.hhoang.cricutweather.models.YahooWeatherQuery;
import com.hhoang.cricutweather.services.YahooWeatherService;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import retrofit2.Retrofit;

public class Home extends AppCompatActivity {


  @Inject Retrofit retrofit;

  @BindView(R.id.detailsPager) ViewPager mViewPager;

  private WeatherPagerAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    // inject dependencies
    ((App) getApplication()).getWeatherComponent().inject(this);
    ButterKnife.bind(this);


    fetchWeather();
  }

  private void fetchWeather() {

    retrofit.create(YahooWeatherService.class)
        .getWeather()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new SingleObserver<YahooWeatherQuery>() {
          @Override public void onSubscribe(Disposable d) {
          }

          @Override public void onSuccess(YahooWeatherQuery yahooWeatherQuery) {
            Log.d("hoa", "onSuccess");

            if (yahooWeatherQuery != null) {
              initPager(yahooWeatherQuery);
            }
          }

          @Override public void onError(Throwable e) {
            Log.d("hoa", "onError");
            Toast.makeText(Home.this, "There was an error fetching weather data. Please try again.",
                Toast.LENGTH_SHORT).show();
          }
        });

  }

  private void initPager(YahooWeatherQuery result) {
    adapter = new WeatherPagerAdapter(getSupportFragmentManager(), result);
    mViewPager.setAdapter(adapter);
    mViewPager.setOffscreenPageLimit(3);
    mViewPager.setCurrentItem(1);
    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(mViewPager);
  }
}
