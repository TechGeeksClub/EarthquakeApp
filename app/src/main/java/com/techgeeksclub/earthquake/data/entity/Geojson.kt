package com.techgeeksclub.earthquake.data.entity

import com.google.gson.annotations.SerializedName


data class Geojson(

    @SerializedName("type")
    var type: String? = null,
    @SerializedName("coordinates")
    var coordinates: ArrayList<Double> = arrayListOf()

)