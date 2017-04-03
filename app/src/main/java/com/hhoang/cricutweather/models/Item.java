
package com.hhoang.cricutweather.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("title")
    public String title;
    @SerializedName("lat")
    public String lat;
    @SerializedName("long")
    public String _long;
    @SerializedName("link")
    public String link;
    @SerializedName("pubDate")
    public String pubDate;
    @SerializedName("condition")
    public Condition condition;
    @SerializedName("forecast")
    public List<Forecast> forecast = null;
    @SerializedName("description")
    public String description;
    @SerializedName("guid")
    public Guid guid;

}
