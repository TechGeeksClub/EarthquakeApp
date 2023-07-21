package com.techgeeksclub.earthquake.repository

import com.techgeeksclub.earthquake.model.Earthquake
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EarthquakeRepository {
    private val apiService : ApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.example.com/") // API base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    fun getEarthquakes(onSuccess : (List<Earthquake>)-> Unit, onFailure: (Throwable) -> Unit){
        val call = apiService.getEarthquakes()

        call.enqueue(object : Callback<List<Earthquake>>{

            override fun onResponse(
                call: Call<List<Earthquake>>,
                response: Response<List<Earthquake>>
            ) {
                if (response.isSuccessful) {
                    val earthquakes = response.body()
                    earthquakes?.let { onSuccess(it) }
                } else {
                    onFailure(Throwable("Couldn't fetch earthquakes"))
                }
            }

            override fun onFailure(call: Call<List<Earthquake>>, t: Throwable) {
                onFailure(t)
            }
        } )
    }
}