package com.dev.weathernews.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.weathernews.common.Resource
import com.dev.weathernews.domain.location.LocationTracker
import com.dev.weathernews.domain.repository.Repository
import com.dev.weathernews.domain.use_case.FetchWeatherUpdateUseCase
import com.dev.weathernews.presentation.stateModel.WeatherUpdateStateModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewmodel @Inject constructor(
    private val locationTracker: LocationTracker,
    private val fetchWeatherUpdateUseCase: FetchWeatherUpdateUseCase
) : ViewModel() {

    private var _state = mutableStateOf(WeatherUpdateStateModel())
    var weatherState = _state

    fun loadWeatherInfo() {
        viewModelScope.launch {
            locationTracker.getCurrentLocation()?.let { location ->
                fetchWeatherUpdateUseCase(location.latitude, location.longitude).collect { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _state.value = _state.value.copy(
                                isLoading = true,
                                errMsg = ""
                            )
                        }
                        is Resource.Success -> {
                            _state.value = _state.value.copy(
                                weatherUpdate = result.data,
                                isLoading = false,
                                errMsg = ""
                            )
                        }

                        is Resource.Error -> {
                            _state.value = _state.value.copy(
                                weatherUpdate = null,
                                isLoading = false,
                                errMsg = result.message ?: "Something went wrong"
                            )
                        }
                    }
                }
            } ?: kotlin.run {
                _state.value = _state.value.copy(
                    isLoading = false,
                    errMsg = "Couldn't retrieve location. Make sure to grant permission and enable GPS."
                )
            }
        }
    }
}