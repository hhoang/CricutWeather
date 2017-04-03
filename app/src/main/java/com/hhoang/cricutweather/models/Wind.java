
package com.hhoang.cricutweather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("chill")
    public String chill;
    @SerializedName("direction")
    public String direction;
    @SerializedName("speed")
    public String speed;

}
