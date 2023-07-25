package com.dev.weathernews.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.dev.weathernews.data.local.Converters
import com.dev.weathernews.domain.model.Main
import com.dev.weathernews.domain.model.WeatherUpdate

@Entity
data class WeatherUpdateEntity(
    //TODO add more fields to adjust more options
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val weatherTimeStamp: Long,
    @TypeConverters(Converters::class)
    val main : Main,

)

fun WeatherUpdateEntity.toWeatherUpdate() : WeatherUpdate {
    return WeatherUpdate(
        id,
        main,
        weatherTimeStamp
    )
}