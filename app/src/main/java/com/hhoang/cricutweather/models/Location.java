
package com.hhoang.cricutweather.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Location implements Parcelable{

    @SerializedName("city")
    public String city;
    @SerializedName("country")
    public String country;
    @SerializedName("region")
    public String region;

    protected Location(Parcel in) {
        city = in.readString();
        country = in.readString();
        region = in.readString();
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(city);
        dest.writeString(country);
        dest.writeString(region);
    }

    @Override public int describeContents() {
        return 0;
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override public Location[] newArray(int size) {
            return new Location[size];
        }
    };
}
