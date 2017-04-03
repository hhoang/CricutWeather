
package com.hhoang.cricutweather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Atmosphere {

    @SerializedName("humidity")
    public String humidity;
    @SerializedName("pressure")
    public String pressure;
    @SerializedName("rising")
    public String rising;
    @SerializedName("visibility")
    public String visibility;

}
