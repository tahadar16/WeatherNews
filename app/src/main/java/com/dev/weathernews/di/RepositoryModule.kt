package com.dev.weathernews.di

import android.content.Context
import com.dev.weathernews.data.repository.RepositoryImpl
import com.dev.weathernews.data.remote.WebApi
import com.dev.weathernews.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideWeatherRepo(
//        db: Database,
        api: WebApi,
        @ApplicationContext context: Context
    ): Repository {
        return RepositoryImpl(
//            db,
            api,
            context
        )
    }
}
