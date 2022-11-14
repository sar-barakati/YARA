package com.yara.android.batman.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yara.android.batman.domain.model.MovieDetail

@Entity
data class MovieDetailEntity(
    val actors: String?,
    val awards: String?,
    val boxOffice: String?,
    val country: String?,
    val dvd: String?,
    val director: String?,
    val genre: String?,
    val language: String?,
    val metaScore: String?,
    val plot: String?,
    val poster: String?,
    val production: String?,
    val rated: String?,
    val released: String?,
    val response: String?,
    val runtime: String?,
    val title: String?,
    val type: String?,
    val website: String?,
    val writer: String?,
    val year: String?,
    @PrimaryKey val imdbID: String,
    val imdbRating: String?,
    val imdbVotes: String?
) {
    fun toMovieDetail(): MovieDetail {
        return MovieDetail(
            actors = actors ?: "",
            director = director ?: "",
            plot = plot ?: "",
            poster = poster ?: "",
            title = title ?: ""
        )
    }
}