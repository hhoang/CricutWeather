
package com.hhoang.cricutweather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Channel {

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

}
