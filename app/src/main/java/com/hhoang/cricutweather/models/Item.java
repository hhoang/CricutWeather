
package com.hhoang.cricutweather.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Item implements Parcelable{

    @SerializedName("title")
    public String title;
    @SerializedName("lat")
    public String lat;
    @SerializedName("long")
    public String _long;
    @SerializedName("link")
    public String link;
    @SerializedName("pubDate")
    public String pubDate;
    @SerializedName("condition")
    public Condition condition;
    @SerializedName("forecast")
    public List<Forecast> forecast = null;
    @SerializedName("description")
    public String description;
    @SerializedName("guid")
    public Guid guid;

    protected Item(Parcel in) {
        title = in.readString();
        lat = in.readString();
        _long = in.readString();
        link = in.readString();
        pubDate = in.readString();
        condition = in.readParcelable(Condition.class.getClassLoader());
        forecast = in.createTypedArrayList(Forecast.CREATOR);
        description = in.readString();
        guid = in.readParcelable(Guid.class.getClassLoader());
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(lat);
        dest.writeString(_long);
        dest.writeString(link);
        dest.writeString(pubDate);
        dest.writeParcelable(condition, flags);
        dest.writeTypedList(forecast);
        dest.writeString(description);
        dest.writeParcelable(guid, flags);
    }

    @Override public int describeContents() {
        return 0;
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
