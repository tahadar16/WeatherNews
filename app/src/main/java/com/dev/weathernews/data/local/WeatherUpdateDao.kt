package com.dev.weathernews.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dev.weathernews.data.local.entity.WeatherUpdateEntity

@Dao
interface WeatherUpdateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherUpdate(weatherUpdate : WeatherUpdateEntity)

    @Delete
    suspend fun removeWeatherUpdate(weatherUpdate: WeatherUpdateEntity)

    @Query("SELECT * FROM WeatherUpdateEntity")
    suspend fun getWeatherUpdate() : List<WeatherUpdateEntity>
}