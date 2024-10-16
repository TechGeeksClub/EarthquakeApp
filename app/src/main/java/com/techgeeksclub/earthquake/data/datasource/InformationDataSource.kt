package com.techgeeksclub.earthquake.data.datasource

import com.techgeeksclub.earthquake.R
import com.techgeeksclub.earthquake.data.entity.InformationItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InformationDataSource {

    suspend fun getInformationItems() : List<InformationItem> = withContext(Dispatchers.IO){
        val informationList = listOf(
            InformationItem(R.drawable.stay_calm,"1. Stay calm and do not panic."),
            InformationItem(R.drawable.cover_hold,"2. Drop, Cover, and Hold On: Get under a sturdy piece of furniture and hold on.")
        )

        return@withContext informationList
    }
}