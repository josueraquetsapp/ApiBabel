package com.magzin.apibabel.data.model

import com.google.gson.annotations.SerializedName

data class ResultsRickMortyModel (
    @SerializedName("id")
    val id:String,

    @SerializedName("name")
    val name:String,

    @SerializedName("episode")
    val episode:String,

    @SerializedName("air_date")
    val airDate:String
)