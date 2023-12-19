package com.techgeeksclub.earthquake.data.entity

import java.io.Serializable

data class EarthquakeResponse(
    var earthquakes : List<Earthquake>
) : Serializable
