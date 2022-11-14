package com.yara.android.batman.data.remote

import com.yara.android.batman.data.remote.dto.MovieDetailDTO
import com.yara.android.batman.data.remote.dto.Search
import retrofit2.http.GET
import retrofit2.http.Query

interface YaraApi {

    @GET("?apikey=3e974fca&s=batman")
    suspend fun getMovies(
    ): Search

    @GET("?apikey=3e974fca")
    suspend fun getMovieDetail(
        @Query("i") imdbID: String
    ): MovieDetailDTO

    companion object {
        const val BASE_URL = "http://www.omdbapi.com/"
    }

}