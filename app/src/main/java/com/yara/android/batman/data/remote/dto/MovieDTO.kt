package com.yara.android.batman.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.yara.android.batman.data.local.entity.MovieEntity

data class MovieDTO(
    @SerializedName("Poster")
    val poster: String?,

    @SerializedName("Title")
    val title: String?,

    @SerializedName("Type")
    val type: String?,

    @SerializedName("Year")
    val year: String?,

    val imdbID: String
) {
    fun toMovieEntity(): MovieEntity {
        return MovieEntity(
            poster = poster,
            title = title,
            type = type,
            year = year,
            imdbID = imdbID
        )
    }
}