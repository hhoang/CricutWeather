
package com.hhoang.cricutweather.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Condition implements Parcelable{

    @SerializedName("code")
    public String code;
    @SerializedName("date")
    public String date;
    @SerializedName("temp")
    public String temp;
    @SerializedName("text")
    public String text;

    protected Condition(Parcel in) {
        code = in.readString();
        date = in.readString();
        temp = in.readString();
        text = in.readString();
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeString(date);
        dest.writeString(temp);
        dest.writeString(text);
    }

    @Override public int describeContents() {
        return 0;
    }

    public static final Creator<Condition> CREATOR = new Creator<Condition>() {
        @Override public Condition createFromParcel(Parcel in) {
            return new Condition(in);
        }

        @Override public Condition[] newArray(int size) {
            return new Condition[size];
        }
    };
}
