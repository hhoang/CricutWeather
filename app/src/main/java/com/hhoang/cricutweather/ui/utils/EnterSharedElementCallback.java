package com.hhoang.cricutweather.ui.utils;


import android.app.SharedElementCallback;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import com.hhoang.cricutweather.R;
import java.util.List;


/**
 * Taken from Alex Lockwood's transition example library
 * https://github.com/alexjlockwood/custom-lollipop-transitions
 *
 */
public class EnterSharedElementCallback extends SharedElementCallback {
  private static final String TAG = "EnterSharedElementCallback";

  private final float mStartTextSize;
  private final float mEndTextSize;

  public EnterSharedElementCallback(Context context) {
    Resources res = context.getResources();
    mStartTextSize = res.getDimensionPixelSize(R.dimen.text_small);
    mEndTextSize = res.getDimensionPixelSize(R.dimen.text_large);
  }

  @Override
  public void onSharedElementStart(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
    TextView textView = (TextView) sharedElements.get(0);

    // Setup the TextView's start values.
    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, mStartTextSize);
  }

  @Override
  public void onSharedElementEnd(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
    TextView textView = (TextView) sharedElements.get(0);

    // Record the TextView's old width/height.
    int oldWidth = textView.getMeasuredWidth();
    int oldHeight = textView.getMeasuredHeight();

    // Setup the TextView's end values.
    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, mEndTextSize);

    // Re-measure the TextView (since the text size has changed).
    int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
    int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
    textView.measure(widthSpec, heightSpec);

    // Record the TextView's new width/height.
    int newWidth = textView.getMeasuredWidth();
    int newHeight = textView.getMeasuredHeight();

    // Layout the TextView in the center of its container, accounting for its new width/height.
    int widthDiff = newWidth - oldWidth;
    int heightDiff = newHeight - oldHeight;
    textView.layout(textView.getLeft() - widthDiff / 2, textView.getTop() - heightDiff / 2,
        textView.getRight() + widthDiff / 2, textView.getBottom() + heightDiff / 2);
    textView.setGravity(Gravity.CENTER_VERTICAL |Gravity.CENTER_HORIZONTAL);
  }
}