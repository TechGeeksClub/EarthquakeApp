package com.techgeeksclub.earthquake.data.datasource

import android.content.Context
import com.techgeeksclub.earthquake.data.entity.Earthquake
import com.techgeeksclub.earthquake.retrofit.EarthquakeDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EarthquakeDataSource(val context: Context,var earthquakeDao: EarthquakeDao){

    suspend fun getEarthquakes() : List<Earthquake> = withContext(Dispatchers.IO){
        return@withContext earthquakeDao.getEarthquakes().earthquakes
    }
}