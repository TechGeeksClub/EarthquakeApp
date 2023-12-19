package com.techgeeksclub.earthquake.data.entity

import java.io.Serializable

data class Earthquake(
    //büyüklük (magnitude), konum (location), tarih (date), zaman (time), derinlik (depth), enlem (latitude), boylam(longitude)
    val magnitude: Double,
    val location: String,
    val date: String,
    val time: String,
    val depth: Double,
    val latitude: Double,
    val longitude: Double
) : Serializable
