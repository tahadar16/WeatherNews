package com.dev.weathernews.domain.model

data class WeatherUpdate(
    val id: Int = -1,
    val main: Main = Main(),
)
