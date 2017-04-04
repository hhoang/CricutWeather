
package com.hhoang.cricutweather.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Units implements Parcelable{

    @SerializedName("distance")
    public String distance;
    @SerializedName("pressure")
    public String pressure;
    @SerializedName("speed")
    public String speed;
    @SerializedName("temperature")
    public String temperature;

    protected Units(Parcel in) {
        distance = in.readString();
        pressure = in.readString();
        speed = in.readString();
        temperature = in.readString();
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(distance);
        dest.writeString(pressure);
        dest.writeString(speed);
        dest.writeString(temperature);
    }

    @Override public int describeContents() {
        return 0;
    }

    public static final Creator<Units> CREATOR = new Creator<Units>() {
        @Override public Units createFromParcel(Parcel in) {
            return new Units(in);
        }

        @Override public Units[] newArray(int size) {
            return new Units[size];
        }
    };
}
