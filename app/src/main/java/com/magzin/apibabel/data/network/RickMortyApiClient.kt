package com.magzin.apibabel.data.network

import com.magzin.apibabel.data.model.RickMortyModel
import retrofit2.Response
import retrofit2.http.GET

interface RickMortyApiClient {
    @GET("/api/episode")
    suspend fun getAllRickMorty():Response<RickMortyModel>
}