package com.dev.weathernews.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WebApi {

    @GET("data/2.5/weather")
    suspend fun fetchWeatherUpdate(
        @Query("lat") lat : Double,
        @Query("lon") long : Double,
        @Query("appid") appid : String,
    )
}