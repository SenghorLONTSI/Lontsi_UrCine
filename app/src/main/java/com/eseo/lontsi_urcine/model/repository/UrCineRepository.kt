package com.eseo.lontsi_urcine.model.repository

import android.util.Log
import com.eseo.lontsi_urcine.model.data.UrCine
import com.eseo.lontsi_urcine.model.service.UrCineApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UrCineRepository @Inject constructor (
    private val UrCineApi: UrCineApi
){

    fun getUrCinesFlow(): Flow<List<UrCine>> = flow {
        emit(UrCineApi.getUrCineResponse())
    }.catch { e ->
        Log.e("UrCineRepository", "Error fetching Movies", e)
        emit(emptyList())
    }
}