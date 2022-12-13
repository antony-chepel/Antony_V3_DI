package com.king.knightsra.di

import com.king.knightsra.api.ApiInterface
import com.king.knightsra.api.HostInterface
import com.king.knightsra.repo.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModule {
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val okHttpClient = OkHttpClient.Builder().addInterceptor(logger)
    @Provides
    @Singleton
    fun provideRetrofitApi() : ApiInterface{
       return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://pro.ip-api.com/")
            .client(okHttpClient.build())
            .build()
           .create(ApiInterface::class.java)
    }


    @Provides
    @Singleton
    fun provideRetrofitHosting() : HostInterface{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://rapturingcrown.xyz/")
            .client(okHttpClient.build())
            .build()
            .create(HostInterface::class.java)
    }


    @Singleton
    @Provides
    fun providesRepository(apiService: ApiInterface,hostInterface: HostInterface) = Repository(apiService,hostInterface)
    }





