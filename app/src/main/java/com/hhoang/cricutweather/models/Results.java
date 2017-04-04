
package com.hhoang.cricutweather.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Results implements Parcelable{

    @SerializedName("channel")
    public Channel channel;

    protected Results(Parcel in) {
        channel = in.readParcelable(Channel.class.getClassLoader());
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(channel, flags);
    }

    @Override public int describeContents() {
        return 0;
    }

    public static final Creator<Results> CREATOR = new Creator<Results>() {
        @Override public Results createFromParcel(Parcel in) {
            return new Results(in);
        }

        @Override public Results[] newArray(int size) {
            return new Results[size];
        }
    };
}
