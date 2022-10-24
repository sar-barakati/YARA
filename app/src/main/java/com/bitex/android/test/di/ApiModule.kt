package com.bitex.android.test.di

import com.bitex.android.test.data.remote.BitexApi
import com.bitex.android.test.data.repositories.BitexRepository
import com.bitex.android.test.util.Constants
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
    fun provideApi(): BitexApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BitexApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api : BitexApi): BitexRepository {
        return BitexRepository(api)
    }

}