
package com.hhoang.cricutweather.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class YahooWeatherQuery implements Parcelable {

    @SerializedName("query")
    public Query query;

    // Helpers
    public Condition getCondition(){
        return query.results.channel.item.condition;
    }


    public Forecast getCurrentForecast(){
        return query.results.channel.item.forecast.get(0);
    }

    public List<Forecast> getForecasts(){
        return query.results.channel.item.forecast;
    }

    protected YahooWeatherQuery(Parcel in) {
        query = in.readParcelable(Query.class.getClassLoader());
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(query, flags);
    }

    @Override public int describeContents() {
        return 0;
    }

    public static final Creator<YahooWeatherQuery> CREATOR = new Creator<YahooWeatherQuery>() {
        @Override public YahooWeatherQuery createFromParcel(Parcel in) {
            return new YahooWeatherQuery(in);
        }

        @Override public YahooWeatherQuery[] newArray(int size) {
            return new YahooWeatherQuery[size];
        }
    };
}
