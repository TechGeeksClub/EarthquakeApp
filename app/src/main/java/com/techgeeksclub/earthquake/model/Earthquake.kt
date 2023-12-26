package com.techgeeksclub.earthquake.model

import com.example.example.Metadata
import com.example.example.Result
import com.google.gson.annotations.SerializedName


data class Earthquake(

    @SerializedName("status")
    var status: Boolean? = null,
    @SerializedName("httpStatus")
    var httpStatus: Int? = null,
    @SerializedName("serverloadms")
    var serverloadms: Int? = null,
    @SerializedName("desc")
    var desc: String? = null,
    @SerializedName("metadata")
    var metadata: Metadata? = Metadata(),
    @SerializedName("result")
    var result: ArrayList<Result> = arrayListOf()

)