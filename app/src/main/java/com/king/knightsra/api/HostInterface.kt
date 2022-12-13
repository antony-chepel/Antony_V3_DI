package com.king.knightsra.api

import com.king.knightsra.data.GeoDev
import retrofit2.Response
import retrofit2.http.GET

interface HostInterface {

    @GET("const.json")
    suspend fun getDataDev(): Response<GeoDev>
}