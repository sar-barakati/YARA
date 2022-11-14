package com.yara.android.batman.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.yara.android.batman.data.local.entity.MovieDetailEntity

data class MovieDetailDTO(
    @SerializedName("Actors")
    val actors: String?,

    @SerializedName("Awards")
    val awards: String?,

    @SerializedName("BoxOffice")
    val boxOffice: String?,

    @SerializedName("Country")
    val country: String?,

    @SerializedName("DVD")
    val dvd: String?,

    @SerializedName("Director")
    val director: String?,

    @SerializedName("Genre")
    val genre: String?,

    @SerializedName("Language")
    val language: String?,

    @SerializedName("Metascore")
    val metaScore: String?,

    @SerializedName("Plot")
    val plot: String?,

    @SerializedName("Poster")
    val poster: String?,

    @SerializedName("Production")
    val production: String?,

    @SerializedName("Rated")
    val rated: String?,

    @SerializedName("Released")
    val released: String?,

    @SerializedName("Response")
    val response: String?,

    @SerializedName("Runtime")
    val runtime: String?,

    @SerializedName("Title")
    val title: String?,

    @SerializedName("Type")
    val type: String?,

    @SerializedName("Website")
    val website: String?,

    @SerializedName("Writer")
    val writer: String?,

    @SerializedName("Year")
    val year: String?,

    @SerializedName("imdbID")
    val imdbID: String,

    @SerializedName("imdbRating")
    val imdbRating: String?,

    @SerializedName("imdbVotes")
    val imdbVotes: String?
) {
    fun toMovieDetailEntity(): MovieDetailEntity {
        return MovieDetailEntity(
            actors = actors,
            awards = awards,
            boxOffice = boxOffice,
            country = country,
            dvd = dvd,
            director = director,
            genre = genre,
            language = language,
            metaScore = metaScore,
            plot = plot,
            poster = poster,
            production = production,
            rated = rated,
            released = released,
            response = response,
            runtime = runtime,
            title = title,
            type = type,
            website = website,
            writer = writer,
            year = year,
            imdbID = imdbID,
            imdbRating = imdbRating,
            imdbVotes = imdbID
        )
    }


}