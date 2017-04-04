
package com.hhoang.cricutweather.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Query implements Parcelable{

    @SerializedName("count")
    public Integer count;
    @SerializedName("created")
    public String created;
    @SerializedName("lang")
    public String lang;
    @SerializedName("results")
    public Results results;

    protected Query(Parcel in) {
        created = in.readString();
        lang = in.readString();
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(created);
        dest.writeString(lang);
    }

    @Override public int describeContents() {
        return 0;
    }

    public static final Creator<Query> CREATOR = new Creator<Query>() {
        @Override public Query createFromParcel(Parcel in) {
            return new Query(in);
        }

        @Override public Query[] newArray(int size) {
            return new Query[size];
        }
    };
}
