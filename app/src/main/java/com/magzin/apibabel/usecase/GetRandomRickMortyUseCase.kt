package com.magzin.apibabel.usecase

import com.magzin.apibabel.data.model.ResultsRickMortyModel
import com.magzin.apibabel.data.model.RickMortyProvider

class GetRandomRickMortyUseCase {

    operator fun invoke(): ResultsRickMortyModel?{
        val rickMorty = RickMortyProvider.rickMorty
        if(!rickMorty.isNullOrEmpty()) {
            val randomNumber = (rickMorty.indices).random()
            return rickMorty[randomNumber]
        }
        return null
    }

}