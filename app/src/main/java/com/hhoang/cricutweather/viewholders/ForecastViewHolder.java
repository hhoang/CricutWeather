package com.hhoang.cricutweather.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.hhoang.cricutweather.R;

/**
 * Created by hoahoang on 4/4/17.
 */

public class ForecastViewHolder extends RecyclerView.ViewHolder {
  @BindView(R.id.day) public TextView day;
  @BindView(R.id.description) public TextView description;
  @BindView(R.id.high) public TextView high;
  @BindView(R.id.low) public TextView low;

  public ForecastViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }
}
