
package com.hhoang.cricutweather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Units {

    @SerializedName("distance")
    public String distance;
    @SerializedName("pressure")
    public String pressure;
    @SerializedName("speed")
    public String speed;
    @SerializedName("temperature")
    public String temperature;

}
