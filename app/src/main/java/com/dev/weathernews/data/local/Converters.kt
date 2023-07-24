package com.dev.weathernews.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dev.weathernews.data.util.JsonParser
import com.dev.weathernews.domain.model.Main
import com.squareup.moshi.Types

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMainJson(json: String): Main {
        val type = Types.newParameterizedType( Main::class.java)
        return jsonParser.fromJson<Main>(json, type) ?: Main()
    }

    @TypeConverter
    fun toMainJson(main: Main): String {
        val type = Types.newParameterizedType(Main::class.java)
        return jsonParser.toJson(main, type) ?: Main().toString()
    }
}