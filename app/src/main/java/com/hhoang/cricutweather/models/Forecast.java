
package com.hhoang.cricutweather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("code")
    public String code;
    @SerializedName("date")
    public String date;
    @SerializedName("day")
    public String day;
    @SerializedName("high")
    public String high;
    @SerializedName("low")
    public String low;
    @SerializedName("text")
    public String text;

}
