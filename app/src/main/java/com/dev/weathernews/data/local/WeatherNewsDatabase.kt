package com.dev.weathernews.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dev.weathernews.data.local.entity.WeatherUpdateEntity

@Database(
    entities = [WeatherUpdateEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class WeatherNewsDatabase: RoomDatabase() {
    abstract val weatherUpdateDao : WeatherUpdateDao
}