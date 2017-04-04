package com.hhoang.cricutweather.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hhoang.cricutweather.ui.activities.DetailActivity;
import com.hhoang.cricutweather.R;
import com.hhoang.cricutweather.models.Forecast;
import com.hhoang.cricutweather.ui.viewholders.ForecastViewHolder;
import java.util.List;

/**
 * Created by hoahoang on 4/4/17.
 */

public class ForecastRecyclerAdapter extends RecyclerView.Adapter<ForecastViewHolder> {
  private final Activity context;
  private List<Forecast> data;

  public ForecastRecyclerAdapter(Activity context, List<Forecast> data) {
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
    final Forecast forecast = this.data.get(i);
    vh.day.setTransitionName("");
    vh.day.setText(forecast.day);
    vh.description.setText(forecast.text);
    vh.high.setText(forecast.high);
    vh.low.setText(forecast.low);
    vh.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        vh.day.setTransitionName("day_transition");
        ActivityOptionsCompat options = ActivityOptionsCompat.
            makeSceneTransitionAnimation(context, vh.day, "day_transition");
        Intent intent = DetailActivity.getDetailIntent(context, forecast.high, forecast.low, forecast.day, forecast.text, String.format(vh.itemView.getContext().getString(R.string.image_url), forecast.code));
        context.startActivity(intent, options.toBundle());
      }
    });
  }

  @Override public int getItemCount() {
    if (this.data != null) {
      return this.data.size();
    }
    return 0;
  }
}
