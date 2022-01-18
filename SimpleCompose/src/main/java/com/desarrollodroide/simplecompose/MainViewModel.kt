package com.desarrollodroide.simplecompose

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desarrollodroide.simplecompose.domain.DummyObjectRepository
import com.desarrollodroide.simplecompose.model.DummyObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dummyObjectRepository: DummyObjectRepository
) : ViewModel() {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { context, throwable ->
        throwable.printStackTrace()
    }

    var list by mutableStateOf<List<DummyObject>>(listOf())
        private set

    var isLoading: MutableState<Boolean> = mutableStateOf(false)
        private set

    init {
        getData()
    }

    private fun getData(){
        isLoading.value = true
        viewModelScope.launch(coroutineExceptionHandler) {
            val result = runCatching { dummyObjectRepository.getDummyObjects() }
            result.onSuccess { response ->
                isLoading.value = false
                list = response
            }.onFailure { throwable ->
                isLoading.value = false
                Log.v("Error!!", throwable.message?:"")
            }
        }
    }
}
