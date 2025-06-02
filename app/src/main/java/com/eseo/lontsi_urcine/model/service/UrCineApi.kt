package com.eseo.lontsi_urcine.model.service

import com.eseo.lontsi_urcine.model.data.UrCine
import retrofit2.http.GET

interface UrCineApi {
    @GET("UrCine")
    suspend fun getUrCineResponse(): List<UrCine>
}