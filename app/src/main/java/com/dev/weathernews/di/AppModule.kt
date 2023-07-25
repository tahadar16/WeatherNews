package com.dev.weathernews.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dev.weathernews.BuildConfig
import com.dev.weathernews.common.Constants
import com.dev.weathernews.data.local.Converters
import com.dev.weathernews.data.local.WeatherNewsDatabase
import com.dev.weathernews.data.remote.WebApi
import com.dev.weathernews.data.util.MoshiParser
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    } else {
        OkHttpClient.Builder().build()
    }

    @Singleton
    @Provides
    fun provideWebApi(okHttpClient: OkHttpClient): WebApi = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .build()
        .create(WebApi::class.java)

    @Provides
    @Singleton
    fun providesMoshi(): Moshi = Moshi.Builder().build()

    @Singleton
    @Provides
    fun provideDatabase(app: Application, moshi: Moshi): WeatherNewsDatabase {
        return Room.databaseBuilder(
            app,
            WeatherNewsDatabase::class.java,
            Constants.DB_NAME
        ).addTypeConverter(Converters(MoshiParser(moshi))).build()
    }

    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(app: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(app)
    }
}