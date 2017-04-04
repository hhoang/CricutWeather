
package com.hhoang.cricutweather.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Wind implements Parcelable{

    @SerializedName("chill")
    public String chill;
    @SerializedName("direction")
    public String direction;
    @SerializedName("speed")
    public String speed;

    protected Wind(Parcel in) {
        chill = in.readString();
        direction = in.readString();
        speed = in.readString();
    }

    public static final Creator<Wind> CREATOR = new Creator<Wind>() {
        @Override public Wind createFromParcel(Parcel in) {
            return new Wind(in);
        }

        @Override public Wind[] newArray(int size) {
            return new Wind[size];
        }
    };

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(chill);
        dest.writeString(direction);
        dest.writeString(speed);
    }
}
