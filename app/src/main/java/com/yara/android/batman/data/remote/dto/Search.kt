package com.yara.android.batman.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Search(
    @SerializedName("Response")
    val sesponse: String,

    @SerializedName("Search")
    val search: List<MovieDTO>,

    @SerializedName("totalResults")
    val totalResults: String
)