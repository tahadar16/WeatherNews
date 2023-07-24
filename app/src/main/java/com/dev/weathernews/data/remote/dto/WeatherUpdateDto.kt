package com.dev.weathernews.data.remote.dto

import com.dev.weathernews.data.local.entity.WeatherUpdateEntity

data class WeatherUpdateDto(
    val base: String,
    val clouds: CloudsDto,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: MainDto,
    val name: String,
    val sys: SysDto,
    val timezone: Int,
    val visibility: Int,
    val weather: List<WeatherDto>,
    val wind: WindDto
)

fun WeatherUpdateDto.toWeatherEntity() : WeatherUpdateEntity {
    return WeatherUpdateEntity(main.toMain(), id)
}