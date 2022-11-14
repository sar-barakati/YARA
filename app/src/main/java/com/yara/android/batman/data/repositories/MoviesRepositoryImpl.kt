package com.yara.android.batman.data.repositories

import com.yara.android.batman.data.local.dao.MovieDao
import com.yara.android.batman.data.remote.YaraApi
import com.yara.android.batman.domain.model.Movie
import com.yara.android.batman.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class MoviesRepositoryImpl constructor(private val api: YaraApi, private val movieDao: MovieDao) :
    MoviesRepository {

    override fun getMovies(): Flow<List<Movie>> = flow {
        val movie = movieDao.getAllMovies().map { it.toMovie() }
        emit(movie)

        try {
            val remoteMovie = api.getMovies()
            movieDao.deleteAllMovies()
            movieDao.insertMovies(remoteMovie.search.map { it.toMovieEntity() })
        } catch (e: HttpException) {
            emit(movie)
        } catch (e: IOException) {
            emit(movie)
        }

        val newMovie = movieDao.getAllMovies().map { it.toMovie() }
        emit(newMovie)

    }


}