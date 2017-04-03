
package com.hhoang.cricutweather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Condition {

    @SerializedName("code")
    public String code;
    @SerializedName("date")
    public String date;
    @SerializedName("temp")
    public String temp;
    @SerializedName("text")
    public String text;

}
