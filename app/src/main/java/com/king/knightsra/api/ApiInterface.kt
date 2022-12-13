package com.king.knightsra.api

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.king.knightsra.data.CountryCodeJS
import com.king.knightsra.data.GeoDev
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("json/?key=ZSSz86ONagSoYRv")
    suspend fun getData(): Response<CountryCodeJS>


}



