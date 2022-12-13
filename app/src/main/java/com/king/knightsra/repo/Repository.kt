package com.king.knightsra.repo

import com.king.knightsra.api.ApiInterface
import com.king.knightsra.api.HostInterface
import javax.inject.Inject

class Repository @Inject constructor(private val apiInterface: ApiInterface,private val hostInterface: HostInterface) {

    suspend fun getData() = apiInterface.getData()
    suspend fun getDataDev() = hostInterface.getDataDev()
}