package com.yara.android.batman.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yara.android.batman.data.local.entity.MovieDetailEntity

@Dao
interface MovieDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDetail(movieDetail: MovieDetailEntity)

    @Query("DELETE FROM MovieDetailEntity WHERE imdbID = :imdbID")
    suspend fun deleteMovieDetail(imdbID: String)

    @Query("SELECT * FROM MovieDetailEntity WHERE imdbID = :imdbID")
    suspend fun getMovieDetail(imdbID: String): MovieDetailEntity?

}