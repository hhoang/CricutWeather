
package com.hhoang.cricutweather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

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

}
