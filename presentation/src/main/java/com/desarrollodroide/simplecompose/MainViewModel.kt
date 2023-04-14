package com.desarrollodroide.simplecompose

import androidx.compose.runtime.*
import androidx.lifecycle.*
import com.desarrollodroide.domain.model.DummyObject
import com.desarrollodroide.domain.model.state.Result
import com.desarrollodroide.domain.usecase.GetDummyObjectsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: GetDummyObjectsUseCase,
) : ViewModel() {

    var list by mutableStateOf<List<DummyObject>?>(listOf())
        private set

    var isLoading: MutableState<Boolean> = mutableStateOf(false)
    private var error: MutableState<Boolean> = mutableStateOf(false)


    init {
        viewModelScope.launch {
            getData()
        }
    }

    suspend fun getData() {
        useCase.execute(Unit)
            .collect { result ->
                when (result) {
                    is Result.Error -> {
                        isLoading.value = false
                        error.value = true
                    }
                    is Result.Loading -> {
                        isLoading.value = true
                        list = result.data
                    }
                    is Result.Success -> {
                        isLoading.value = false
                        list = result.data
                    }
                }
            }
    }
}
