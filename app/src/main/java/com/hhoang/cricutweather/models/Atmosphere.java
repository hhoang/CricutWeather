
package com.hhoang.cricutweather.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Atmosphere implements Parcelable{

    @SerializedName("humidity")
    public String humidity;
    @SerializedName("pressure")
    public String pressure;
    @SerializedName("rising")
    public String rising;
    @SerializedName("visibility")
    public String visibility;

    protected Atmosphere(Parcel in) {
        humidity = in.readString();
        pressure = in.readString();
        rising = in.readString();
        visibility = in.readString();
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(humidity);
        dest.writeString(pressure);
        dest.writeString(rising);
        dest.writeString(visibility);
    }

    @Override public int describeContents() {
        return 0;
    }

    public static final Creator<Atmosphere> CREATOR = new Creator<Atmosphere>() {
        @Override public Atmosphere createFromParcel(Parcel in) {
            return new Atmosphere(in);
        }

        @Override public Atmosphere[] newArray(int size) {
            return new Atmosphere[size];
        }
    };
}
