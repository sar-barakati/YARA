package com.bitex.android.test.data.repositories

import com.bitex.android.test.data.dto.ApiResponseDto
import com.bitex.android.test.data.remote.BitexApi
import javax.inject.Inject

class BitexRepository @Inject constructor(val api: BitexApi) {

    suspend fun getData(amount: Int): List<ApiResponseDto> {
        return api.getData(amount, "BTC")
    }

}