package com.yara.android.batman.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yara.android.batman.data.local.entity.MovieEntity

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Query("DELETE FROM MovieEntity")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM MovieEntity")
    suspend fun getAllMovies(): List<MovieEntity>

}