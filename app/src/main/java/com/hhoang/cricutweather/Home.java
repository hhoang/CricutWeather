package com.hhoang.cricutweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.hhoang.cricutweather.models.YahooWeatherQuery;
import com.hhoang.cricutweather.services.YahooWeatherService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
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
}
