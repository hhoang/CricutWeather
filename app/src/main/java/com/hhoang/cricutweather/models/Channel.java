
package com.hhoang.cricutweather.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Channel implements Parcelable{

    @SerializedName("units")
    public Units units;
    @SerializedName("title")
    public String title;
    @SerializedName("link")
    public String link;
    @SerializedName("description")
    public String description;
    @SerializedName("language")
    public String language;
    @SerializedName("lastBuildDate")
    public String lastBuildDate;
    @SerializedName("ttl")
    public String ttl;
    @SerializedName("location")
    public Location location;
    @SerializedName("wind")
    public Wind wind;
    @SerializedName("atmosphere")
    public Atmosphere atmosphere;
    @SerializedName("astronomy")
    public Astronomy astronomy;
    @SerializedName("image")
    public Image image;
    @SerializedName("item")
    public Item item;

    protected Channel(Parcel in) {
        title = in.readString();
        link = in.readString();
        description = in.readString();
        language = in.readString();
        lastBuildDate = in.readString();
        ttl = in.readString();
        wind = in.readParcelable(Wind.class.getClassLoader());
        atmosphere = in.readParcelable(Atmosphere.class.getClassLoader());
        astronomy = in.readParcelable(Astronomy.class.getClassLoader());
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(link);
        dest.writeString(description);
        dest.writeString(language);
        dest.writeString(lastBuildDate);
        dest.writeString(ttl);
        dest.writeParcelable(wind, flags);
        dest.writeParcelable(atmosphere, flags);
        dest.writeParcelable(astronomy, flags);
    }

    @Override public int describeContents() {
        return 0;
    }

    public static final Creator<Channel> CREATOR = new Creator<Channel>() {
        @Override public Channel createFromParcel(Parcel in) {
            return new Channel(in);
        }

        @Override public Channel[] newArray(int size) {
            return new Channel[size];
        }
    };
}
