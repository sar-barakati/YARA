package com.yara.android.batman.domain.repository

import com.yara.android.batman.domain.model.MovieDetail
import kotlinx.coroutines.flow.Flow


interface MovieDetailRepository {

    fun getMovieDetail(imdbID: String): Flow<MovieDetail>

}