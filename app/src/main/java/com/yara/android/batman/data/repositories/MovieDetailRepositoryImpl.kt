package com.yara.android.batman.data.repositories

import com.yara.android.batman.data.local.dao.MovieDetailDao
import com.yara.android.batman.data.remote.YaraApi
import com.yara.android.batman.domain.model.MovieDetail
import com.yara.android.batman.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


import retrofit2.HttpException
import java.io.IOException

class MovieDetailRepositoryImpl constructor(
    private val api: YaraApi,
    private val movieDetailDao: MovieDetailDao
) : MovieDetailRepository {

    override fun getMovieDetail(imdbID: String): Flow<MovieDetail> = flow {
        val movieDetail = movieDetailDao.getMovieDetail(imdbID)?.toMovieDetail() ?: MovieDetail()
        emit(movieDetail)

        try {
            val remoteMovieDetail = api.getMovieDetail(imdbID)
            movieDetailDao.deleteMovieDetail(imdbID)
            movieDetailDao.insertMovieDetail(remoteMovieDetail.toMovieDetailEntity())
        } catch (e: HttpException) {
            emit(movieDetail)
        } catch (e: IOException) {
            emit(movieDetail)
        }

        val newMovieDetail = movieDetailDao.getMovieDetail(imdbID)?.toMovieDetail() ?: MovieDetail()
        emit(newMovieDetail)
    }


}