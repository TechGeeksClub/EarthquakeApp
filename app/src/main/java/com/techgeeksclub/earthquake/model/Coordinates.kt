package com.example.example

import com.google.gson.annotations.SerializedName


data class Coordinates(

    @SerializedName("type")
    var type: String? = null,
    @SerializedName("coordinates")
    var coordinates: ArrayList<Double> = arrayListOf()

)