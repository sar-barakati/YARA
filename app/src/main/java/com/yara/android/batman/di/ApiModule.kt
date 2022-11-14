package com.yara.android.batman.di

import android.app.Application
import androidx.room.Room
import com.yara.android.batman.data.local.YaraDatabase
import com.yara.android.batman.data.remote.YaraApi
import com.yara.android.batman.data.remote.YaraApi.Companion.BASE_URL
import com.yara.android.batman.data.repositories.MovieDetailRepositoryImpl
import com.yara.android.batman.data.repositories.MoviesRepositoryImpl
import com.yara.android.batman.domain.repository.MovieDetailRepository
import com.yara.android.batman.domain.repository.MoviesRepository
import com.yara.android.batman.domain.use_case.GetMovieDetail
import com.yara.android.batman.domain.use_case.GetMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideGetMoviesUseCase(repository: MoviesRepository): GetMovies {
        return GetMovies(repository)
    }

    @Provides
    @Singleton
    fun provideGetMovieDetailUseCase(repository: MovieDetailRepository): GetMovieDetail {
        return GetMovieDetail(repository)
    }

    @Provides
    @Singleton
    fun provideYaraDatabase(app: Application): YaraDatabase {
        return Room.databaseBuilder(
            app, YaraDatabase::class.java, "yara_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideApi(): YaraApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(YaraApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMoviesRepository(
        db: YaraDatabase,
        api: YaraApi
    ): MoviesRepository {
        return MoviesRepositoryImpl(api, db.movieDao)
    }

    @Provides
    @Singleton
    fun provideMovieDetailRepository(
        db: YaraDatabase,
        api: YaraApi
    ): MovieDetailRepository {
        return MovieDetailRepositoryImpl(api, db.movieDetailDao)
    }

}