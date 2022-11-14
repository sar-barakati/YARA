package com.yara.android.batman.domain.use_case

import com.yara.android.batman.domain.model.Movie
import com.yara.android.batman.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetMovies(private val moviesRepository: MoviesRepository) {

    operator fun invoke(): Flow<List<Movie>> {
        return moviesRepository.getMovies()
    }

}