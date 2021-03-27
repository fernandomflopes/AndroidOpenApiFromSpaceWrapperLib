package br.com.fernandomflopes.issapiwrapper.model

import com.google.gson.annotations.SerializedName

data class ISSNow(
    @SerializedName("iss_position") val position: LatLong,
    val message: String
)
