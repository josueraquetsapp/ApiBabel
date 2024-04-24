package com.magzin.apibabel.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.magzin.apibabel.data.model.ResultsRickMortyModel
import com.magzin.apibabel.usecase.GetRandomRickMortyUseCase
import com.magzin.apibabel.usecase.GetRickMortyUseCase
import kotlinx.coroutines.launch
import mu.KotlinLogging

class RickMortyViewModel : ViewModel() {

    private val logger = KotlinLogging.logger {}

    val rickMortyModel = MutableLiveData<List<ResultsRickMortyModel>?>()
    val isLoading = MutableLiveData<Boolean>()

    var getRickMortyUseCase = GetRickMortyUseCase()
    var getRandomRickMortyUseCase = GetRandomRickMortyUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getRickMortyUseCase()

            if(!result.isNullOrEmpty()) {
                logger.info { "RickMortyViewModel :: $result" }
                rickMortyModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun randomRickMorty() {
        isLoading.postValue(true)
         var rickMorty = getRandomRickMortyUseCase()
        if(rickMorty!=null) {
            rickMortyModel.postValue(listOf(rickMorty!!))
        }
        isLoading.postValue(false)
    }

}