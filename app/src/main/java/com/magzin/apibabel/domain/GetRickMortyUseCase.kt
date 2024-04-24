package com.magzin.apibabel.domain

import com.magzin.apibabel.data.RickMortyRepository
import com.magzin.apibabel.data.model.ResultsRickMortyModel

class GetRickMortyUseCase {

    private val repository = RickMortyRepository()

    suspend operator fun invoke():List<ResultsRickMortyModel>? = repository.getAllRickMorty()
}