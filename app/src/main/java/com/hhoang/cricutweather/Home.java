package com.hhoang.cricutweather;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.hhoang.cricutweather.adapters.WeatherPagerAdapter;
import com.hhoang.cricutweather.models.YahooWeatherQuery;
import com.hhoang.cricutweather.services.YahooWeatherService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {

  private WeatherPagerAdapter adapter;

  @BindView(R.id.detailsPager) ViewPager mViewPager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    ButterKnife.bind(this);
    initPager();

    fetchWeather();
  }

  private void fetchWeather() {
    YahooWeatherService service = YahooWeatherService.api.create(YahooWeatherService.class);
    Call<YahooWeatherQuery> call = service.getWeather();
    call.enqueue(new Callback<YahooWeatherQuery>() {
      @Override
      public void onResponse(Call<YahooWeatherQuery> call, Response<YahooWeatherQuery> response) {
        Log.d("hoa", "onResponse");

        if(response.body() != null){
          Log.d("hoa", "Response count : " + response.body().query.count);
        }
      }

      @Override public void onFailure(Call<YahooWeatherQuery> call, Throwable t) {
        Log.d("hoa", "onFailure");

      }
    });
  }

  private void initPager() {
    adapter = new WeatherPagerAdapter(getSupportFragmentManager());
    mViewPager.setAdapter(adapter);
    mViewPager.setOffscreenPageLimit(3);
    mViewPager.setCurrentItem(1);
    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(mViewPager);
  }
}
