package com.dev.weathernews.data.repository

import android.content.Context
import com.dev.weathernews.R
import com.dev.weathernews.common.Constants
import com.dev.weathernews.common.Resource
import com.dev.weathernews.data.local.entity.toWeatherUpdate
import com.dev.weathernews.data.remote.WebApi
import com.dev.weathernews.data.remote.dto.toWeatherEntity
import com.dev.weathernews.domain.model.WeatherUpdate
import com.dev.weathernews.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: WebApi,
    private val context: Context
) : Repository {
    override suspend fun fetchWeatherUpdate(
        lat: Double,
        long: Double,
    ): Flow<Resource<WeatherUpdate>> {
        return flow {
            try {
                emit(Resource.Loading())
                //TODO store api key in local properties instead of in constants
                val response = api.fetchWeatherUpdate(lat, long, Constants.API_KEY)
                response.body()?.let { weatherUpdate ->
                    //TODO save in db and fetch from db to return to presentation domain layer
                    return@flow emit(
                        Resource.Success(
                            weatherUpdate.toWeatherEntity().toWeatherUpdate()
                        )
                    )
                }
                emit(Resource.Error(message = context.getString(R.string.unexpected_error)))
            } catch (error: HttpException) {
                emit(
                    Resource.Error(
                        message = error.localizedMessage
                            ?: context.getString(R.string.something_went_wrong)
                    )
                )
            } catch (error: IOException) {
                emit(
                    Resource.Error(context.getString(R.string.could_not_connect))
                )
            }
        }
    }
}