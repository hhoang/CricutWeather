
package com.hhoang.cricutweather.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Image implements Parcelable{

    @SerializedName("title")
    public String title;
    @SerializedName("width")
    public String width;
    @SerializedName("height")
    public String height;
    @SerializedName("link")
    public String link;
    @SerializedName("url")
    public String url;

    protected Image(Parcel in) {
        title = in.readString();
        width = in.readString();
        height = in.readString();
        link = in.readString();
        url = in.readString();
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(width);
        dest.writeString(height);
        dest.writeString(link);
        dest.writeString(url);
    }

    @Override public int describeContents() {
        return 0;
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override public Image[] newArray(int size) {
            return new Image[size];
        }
    };
}
