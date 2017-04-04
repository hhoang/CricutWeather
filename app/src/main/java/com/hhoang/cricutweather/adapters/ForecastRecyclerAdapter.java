package com.hhoang.cricutweather.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hhoang.cricutweather.R;
import com.hhoang.cricutweather.models.Forecast;
import com.hhoang.cricutweather.viewholders.ForecastViewHolder;
import java.util.List;

/**
 * Created by hoahoang on 4/4/17.
 */

public class ForecastRecyclerAdapter extends RecyclerView.Adapter<ForecastViewHolder> {
  private final Context context;
  private List<Forecast> data;

  public ForecastRecyclerAdapter(Context context, List<Forecast> data) {
    this.data = data;
    this.context = context;

  }

  @Override public ForecastViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
    final LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
    final View v = layoutInflater.inflate(R.layout.item_forecast, viewGroup, false);
    return new ForecastViewHolder(v);
  }

  @Override
  public void onBindViewHolder(final ForecastViewHolder vh, int i) {
    Forecast forecast = this.data.get(i);
    vh.day.setText(forecast.day);
    vh.description.setText(forecast.text);
    vh.high.setText(forecast.high);
    vh.low.setText(forecast.low);
  }

  @Override public int getItemCount() {
    if (this.data != null) {
      return this.data.size();
    }
    return 0;
  }
}
