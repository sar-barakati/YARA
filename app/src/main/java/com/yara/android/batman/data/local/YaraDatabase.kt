package com.yara.android.batman.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yara.android.batman.data.local.dao.MovieDao
import com.yara.android.batman.data.local.dao.MovieDetailDao
import com.yara.android.batman.data.local.entity.MovieDetailEntity
import com.yara.android.batman.data.local.entity.MovieEntity

@Database(entities = [MovieEntity::class, MovieDetailEntity::class], version = 1)

abstract class YaraDatabase : RoomDatabase() {

    abstract val movieDao: MovieDao

    abstract val movieDetailDao: MovieDetailDao

}