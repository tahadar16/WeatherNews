package com.dev.weathernews.domain.repository

import com.dev.weathernews.common.Resource
import com.dev.weathernews.data.remote.WebApi
import com.dev.weathernews.domain.model.WeatherUpdate
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface Repository {
    suspend fun fetchWeatherUpdate(
        lat: Double,
        long: Double,
    ): Flow<Resource<WeatherUpdate>>
}