
package com.hhoang.cricutweather.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Forecast implements Parcelable{

    @SerializedName("code")
    public String code;
    @SerializedName("date")
    public String date;
    @SerializedName("day")
    public String day;
    @SerializedName("high")
    public String high;
    @SerializedName("low")
    public String low;
    @SerializedName("text")
    public String text;

    protected Forecast(Parcel in) {
        code = in.readString();
        date = in.readString();
        day = in.readString();
        high = in.readString();
        low = in.readString();
        text = in.readString();
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeString(date);
        dest.writeString(day);
        dest.writeString(high);
        dest.writeString(low);
        dest.writeString(text);
    }

    @Override public int describeContents() {
        return 0;
    }

    public static final Creator<Forecast> CREATOR = new Creator<Forecast>() {
        @Override public Forecast createFromParcel(Parcel in) {
            return new Forecast(in);
        }

        @Override public Forecast[] newArray(int size) {
            return new Forecast[size];
        }
    };
}
