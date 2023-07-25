package com.dev.weathernews.presentation.stateModel

import com.dev.weathernews.domain.model.WeatherUpdate

data class WeatherUpdateStateModel(
    var weatherUpdate: WeatherUpdate? = null,
    var isLoading: Boolean = false,
    var errMsg : String = ""
)
