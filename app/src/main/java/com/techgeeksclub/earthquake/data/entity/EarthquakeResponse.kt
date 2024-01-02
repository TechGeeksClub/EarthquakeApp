package com.techgeeksclub.earthquake.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class EarthquakeResponse(
    @SerializedName("")
    var earthquakes : List<Earthquake>
) : Serializable
