package com.techgeeksclub.earthquake.data.repository

import com.techgeeksclub.earthquake.data.datasource.EarthquakeDataSource
import com.techgeeksclub.earthquake.data.entity.Earthquake
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EarthquakeRepository (var earthquakeDataSource: EarthquakeDataSource){

    suspend fun getEarthquakes() : Earthquake = earthquakeDataSource.getEarthquakes()
}