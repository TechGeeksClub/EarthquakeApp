package com.example.example

import com.google.gson.annotations.SerializedName


data class LocationProperties(

    @SerializedName("closestCity")
    var closestCity: ClosestCity? = ClosestCity(),
    @SerializedName("epiCenter")
    var epiCenter: EpiCenter? = EpiCenter(),
    @SerializedName("closestCities")
    var closestCities: ArrayList<ClosestCities> = arrayListOf(),
    @SerializedName("airports")
    var airports: ArrayList<Airports> = arrayListOf()

)