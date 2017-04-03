package com.hhoang.cricutweather.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hhoang.cricutweather.R;

/**
 * Created by hoahoang on 4/3/17.
 */

public class WeatherPagerAdapter extends FragmentPagerAdapter {

  public WeatherPagerAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override public Fragment getItem(int position) {

    switch (position) {
      case 0:
        return PlaceholderFragment.newInstance();
      case 1:
        return PlaceholderFragment.newInstance();
      case 2:
        return PlaceholderFragment.newInstance();
      default:
        return PlaceholderFragment.newInstance();
    }
  }

  @Override public int getCount() {
    // Show 3 total pages.
    return 3;
  }

  @Override public CharSequence getPageTitle(int position) {
    switch (position) {
      case 0:
        return "Current";
      case 1:
        return "Forecast";
      case 2:
        return "Details";
    }
    return null;
  }

  public static class PlaceholderFragment extends Fragment {

    public PlaceholderFragment() {}

    public static PlaceholderFragment newInstance() {
      PlaceholderFragment fragment = new PlaceholderFragment();
      Bundle args = new Bundle();
      //args.putInt(SOME_DATA, data);
      fragment.setArguments(args);
      return fragment;
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      return inflater.inflate(R.layout.fragment_detail, container, false);
    }
  }
}
