package com.magzin.apibabel.data.model

import com.google.gson.annotations.SerializedName

data class RickMortyModel (
    @SerializedName("results")
    val results:ArrayList<ResultsRickMortyModel>
)