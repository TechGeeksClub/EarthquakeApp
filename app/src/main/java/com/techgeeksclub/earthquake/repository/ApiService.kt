package com.techgeeksclub.earthquake.repository

import com.techgeeksclub.earthquake.model.Earthquake
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("earthquakes") // API'den verileri almak için kullanılacak endpoint
    fun getEarthquakes(): Call<List<Earthquake>>
}