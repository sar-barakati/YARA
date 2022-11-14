package com.yara.android.batman.domain.use_case

import com.yara.android.batman.domain.model.MovieDetail
import com.yara.android.batman.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow

class GetMovieDetail(private val movieDetailRepository: MovieDetailRepository) {

    operator fun invoke(imdbID: String): Flow<MovieDetail> {
        return movieDetailRepository.getMovieDetail(imdbID)
    }

}