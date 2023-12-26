package com.techgeeksclub.earthquake.data.entity

import com.google.gson.annotations.SerializedName
import com.techgeeksclub.earthquake.data.entity.Airports
import com.techgeeksclub.earthquake.data.entity.ClosestCities
import com.techgeeksclub.earthquake.data.entity.ClosestCity
import com.techgeeksclub.earthquake.data.entity.EpiCenter


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