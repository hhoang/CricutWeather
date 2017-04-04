package com.hhoang.cricutweather.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.hhoang.cricutweather.R;
import com.hhoang.cricutweather.ui.utils.EnterSharedElementCallback;
import com.hhoang.cricutweather.ui.utils.TextSizeTransition;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

  @BindView(R.id.day) TextView dayTV;
  @BindView(R.id.low_text) TextView lowTV;
  @BindView(R.id.high_text) TextView highTV;
  @BindView(R.id.image) ImageView imageView;
  @BindView(R.id.description) TextView descriptionTV;

  public static Intent getDetailIntent(Context context, String high, String low, String day, String description, String imageUrl){
    Intent intent = new Intent(context, DetailActivity.class);
    intent.putExtra("high", high);
    intent.putExtra("low", low);
    intent.putExtra("day", day);
    intent.putExtra("description", description);
    intent.putExtra("url", imageUrl);
    return intent;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    ButterKnife.bind(this);

    TextSizeTransition handler = new TextSizeTransition(this, null);

    getWindow().setEnterTransition(makeEnterTransition());
    getWindow().setSharedElementEnterTransition(makeSharedElementEnterTransition(this));

    setEnterSharedElementCallback(new EnterSharedElementCallback(this));
    String high, low, day, description, url;
    if(getIntent() != null && getIntent().getExtras() != null){
      high = getIntent().getExtras().getString("high");
      low = getIntent().getExtras().getString("low");
      day = getIntent().getExtras().getString("day");
      description = getIntent().getExtras().getString("description");
      url = getIntent().getExtras().getString("url");

      dayTV.setText(day);
      lowTV.setText(low);
      highTV.setText(high);
      descriptionTV.setText(description);
      Picasso.with(DetailActivity.this).load(url).into(imageView);
    }
  }
  public static Transition makeEnterTransition() {
    Transition fade = new Fade();
    fade.excludeTarget(android.R.id.navigationBarBackground, true);
    fade.excludeTarget(android.R.id.statusBarBackground, true);
    return fade;
  }

  public static Transition makeSharedElementEnterTransition(Context context) {
    TransitionSet set = new TransitionSet();
    set.setOrdering(TransitionSet.ORDERING_TOGETHER);

    Transition changeBounds = new ChangeBounds();
    changeBounds.addTarget(R.id.day);
    changeBounds.addTarget("day_transition");
    set.addTransition(changeBounds);

    Transition textSize = new TextSizeTransition();
    textSize.addTarget(R.id.day);
    textSize.addTarget("day_transition");
    set.addTransition(textSize);

    return set;
  }

}
