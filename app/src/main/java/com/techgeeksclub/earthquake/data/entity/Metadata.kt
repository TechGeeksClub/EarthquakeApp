package com.techgeeksclub.earthquake.data.entity

import com.google.gson.annotations.SerializedName


data class Metadata(

    @SerializedName("date_starts")
    var dateStarts: String? = null,
    @SerializedName("date_ends")
    var dateEnds: String? = null,
    @SerializedName("total")
    var total: Int? = null

)