package com.yara.android.batman.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yara.android.batman.domain.model.Movie

@Entity
data class MovieEntity(
    val poster: String? = "",
    val title: String? = "",
    val type: String? = "",
    val year: String? = "",
    @PrimaryKey val imdbID: String,
) {
    fun toMovie(): Movie {
        return Movie(
            poster = poster ?: "",
            title = title ?: "",
            imdbID = imdbID ,
            year = year ?: ""
        )
    }
}