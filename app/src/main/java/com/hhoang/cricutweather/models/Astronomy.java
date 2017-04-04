
package com.hhoang.cricutweather.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Astronomy implements Parcelable{

    @SerializedName("sunrise")
    public String sunrise;
    @SerializedName("sunset")
    public String sunset;

    protected Astronomy(Parcel in) {
        sunrise = in.readString();
        sunset = in.readString();
    }

    public static final Creator<Astronomy> CREATOR = new Creator<Astronomy>() {
        @Override public Astronomy createFromParcel(Parcel in) {
            return new Astronomy(in);
        }

        @Override public Astronomy[] newArray(int size) {
            return new Astronomy[size];
        }
    };

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sunrise);
        dest.writeString(sunset);
    }
}
