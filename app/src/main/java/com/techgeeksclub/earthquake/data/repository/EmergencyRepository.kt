package com.techgeeksclub.earthquake.data.repository

import android.content.Context
import com.techgeeksclub.earthquake.R
import com.techgeeksclub.earthquake.data.datasource.EmergencyDataSource
import com.techgeeksclub.earthquake.data.entity.EmergencyItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EmergencyRepository (var emergencyDataSource: EmergencyDataSource){

    suspend fun getEmergencyItems() : List<EmergencyItem> = emergencyDataSource.getEmergencyItems()
}