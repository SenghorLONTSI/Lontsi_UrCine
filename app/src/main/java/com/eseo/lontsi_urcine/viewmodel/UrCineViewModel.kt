package com.eseo.lontsi_urcine.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eseo.lontsi_urcine.model.data.UrCine
import com.eseo.lontsi_urcine.model.repository.UrCineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class UrCineViewModel @Inject constructor(
    private val UrCineRepository: UrCineRepository
) : ViewModel() {

    private val _urcines = MutableStateFlow<List<UrCine>>(emptyList())
    val urcines: StateFlow<List<UrCine>> = _urcines

    init {
        getAllUrCines()
    }

    private fun getAllUrCines() = viewModelScope.launch(Dispatchers.IO) {
        UrCineRepository.getUrCinesFlow().collectLatest {
            _urcines.value = it
        }
    }

}