package com.dev.weathernews.data.repository

import android.content.Context
import com.dev.weathernews.data.remote.WebApi
import com.dev.weathernews.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    api: WebApi,
    context: Context
): Repository {
}