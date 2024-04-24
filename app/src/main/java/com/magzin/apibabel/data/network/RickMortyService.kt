package com.magzin.apibabel.data.network

import com.magzin.apibabel.core.RetrofitHelper
import com.magzin.apibabel.data.model.ResultsRickMortyModel
import mu.KotlinLogging
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RickMortyService {
    private val logger = KotlinLogging.logger {}
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getRickMorty():ArrayList<ResultsRickMortyModel>{
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(RickMortyApiClient::class.java).getAllRickMorty()
            logger.info { "RickMortyService :: $response" }
            (response.body()?.results ?: emptyList()) as ArrayList<ResultsRickMortyModel>
        }
    }
}