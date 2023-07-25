package com.dev.weathernews.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dev.weathernews.presentation.WeatherViewmodel
import com.dev.weathernews.presentation.components.WeatherInfoCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherInfoScreen(
    viewmodel: WeatherViewmodel = hiltViewModel()
) {
    val state = viewmodel.weatherState.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("WeatherNews") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    actionIconContentColor = Color.White,
                    titleContentColor = Color.White,
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                actions = {
                    IconButton(
                        onClick = { /* Handle action click */ }
                    ) {
                        Icon(Icons.Default.Save, contentDescription = "More")
                    }
                }
            )
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            state.weatherUpdate?.let {
                WeatherInfoCard(weatherUpdate = it)
            } ?:
            if (state.errMsg.isNotBlank()) {
                Text(
                    text = state.errMsg,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .align(Alignment.Center)
                )
            } else if (state.isLoading) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
        }
    }
}