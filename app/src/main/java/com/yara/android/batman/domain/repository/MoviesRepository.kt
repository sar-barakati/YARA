package com.yara.android.batman.domain.repository

import com.yara.android.batman.domain.model.Movie
import kotlinx.coroutines.flow.Flow


interface MoviesRepository {

    fun getMovies(): Flow<List<Movie>>

}