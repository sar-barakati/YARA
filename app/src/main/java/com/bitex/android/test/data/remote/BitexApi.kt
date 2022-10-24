package com.bitex.android.test.data.remote

import com.bitex.android.test.data.dto.ApiResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface BitexApi {

    @GET("v1/order")
    suspend fun getData(
        @Query("amount") amount: Int,
        @Query("token") token: String
    ): List<ApiResponseDto>

}