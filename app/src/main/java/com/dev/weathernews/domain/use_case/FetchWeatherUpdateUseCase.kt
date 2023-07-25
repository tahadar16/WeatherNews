package com.dev.weathernews.domain.use_case

import com.dev.weathernews.common.Resource
import com.dev.weathernews.domain.model.WeatherUpdate
import com.dev.weathernews.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchWeatherUpdateUseCase @Inject constructor(
    private val repo: Repository
) {
    suspend operator fun invoke(lat: Double, long: Double) : Flow<Resource<WeatherUpdate>> {
        return repo.fetchWeatherUpdate(lat, long)
    }
}