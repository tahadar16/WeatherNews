package com.dev.weathernews.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dev.weathernews.data.remote.dto.Coord
import com.dev.weathernews.data.remote.dto.MainDto
import com.dev.weathernews.data.remote.dto.WeatherDto
import com.dev.weathernews.domain.model.Main

@Entity
data class WeatherUpdateEntity(
    //TODO add more fields to adjust more options
    val main : Main,
    @PrimaryKey(autoGenerate = false)
    val id: Int
)