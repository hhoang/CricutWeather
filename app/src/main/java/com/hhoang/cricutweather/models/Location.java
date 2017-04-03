
package com.hhoang.cricutweather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("city")
    public String city;
    @SerializedName("country")
    public String country;
    @SerializedName("region")
    public String region;

}
