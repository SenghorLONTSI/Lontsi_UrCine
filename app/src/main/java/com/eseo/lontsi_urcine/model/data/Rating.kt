package com.eseo.lontsi_urcine.model.data


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("total")
    val total: Int?,
    @SerializedName("tv_shows")
    val tvShows: List<UrCine?>?
)