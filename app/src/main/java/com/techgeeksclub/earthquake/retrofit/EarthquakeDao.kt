package com.techgeeksclub.earthquake.retrofit

import com.techgeeksclub.earthquake.data.entity.Earthquake
import retrofit2.http.GET


interface EarthquakeDao {

    @GET("deprem/kandilli/live")
    suspend fun getEarthquakes(): Earthquake
}