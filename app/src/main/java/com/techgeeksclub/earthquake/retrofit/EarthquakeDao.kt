package com.techgeeksclub.earthquake.retrofit

import com.techgeeksclub.earthquake.data.entity.EarthquakeResponse
import retrofit2.http.GET

interface EarthquakeDao {

    @GET("earthquakes")
    fun getEarthquakes(): EarthquakeResponse
}