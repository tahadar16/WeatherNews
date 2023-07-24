package com.dev.weathernews.data.remote.dto

import com.dev.weathernews.domain.model.Main

data class MainDto(
    val feels_like: Double,
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double
)

fun MainDto.toMain() : Main {
    return Main(feels_like, humidity, pressure, temp)
}