
package com.hhoang.cricutweather.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Guid implements Parcelable{

    @SerializedName("isPermaLink")
    public String isPermaLink;

    protected Guid(Parcel in) {
        isPermaLink = in.readString();
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(isPermaLink);
    }

    @Override public int describeContents() {
        return 0;
    }

    public static final Creator<Guid> CREATOR = new Creator<Guid>() {
        @Override public Guid createFromParcel(Parcel in) {
            return new Guid(in);
        }

        @Override public Guid[] newArray(int size) {
            return new Guid[size];
        }
    };
}
