package com.example.example

import com.google.gson.annotations.SerializedName


data class ClosestCity(

    @SerializedName("name")
    var name: String? = null,
    @SerializedName("cityCode")
    var cityCode: Int? = null,
    @SerializedName("distance")
    var distance: Double? = null,
    @SerializedName("population")
    var population: Int? = null

)