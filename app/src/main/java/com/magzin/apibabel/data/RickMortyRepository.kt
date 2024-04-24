package com.magzin.apibabel.data

import com.magzin.apibabel.data.model.ResultsRickMortyModel
import com.magzin.apibabel.data.model.RickMortyModel
import com.magzin.apibabel.data.model.RickMortyProvider
import com.magzin.apibabel.data.network.RickMortyService

class RickMortyRepository {

    private val api = RickMortyService()

    suspend fun getAllRickMorty():List<ResultsRickMortyModel> {
        val response = api.getRickMorty();
        RickMortyProvider.rickMorty = response
        return response
    }
}