package com.techgeeksclub.earthquake.retrofit

import com.techgeeksclub.earthquake.data.entity.Earthquake
import com.techgeeksclub.earthquake.data.entity.EarthquakeResponse
import retrofit2.Call
import retrofit2.http.GET


interface EarthquakeDao {

    @GET("deprem/kandilli/live")
    fun getEarthquakes(): EarthquakeResponse
}