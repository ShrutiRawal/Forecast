package com.example.forecast.data.network

import androidx.lifecycle.LiveData
import com.example.forecast.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
    //val downloadedFutureWeather: LiveData<FutureWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String
    )
    /*suspend fun fetchFutureWeather(
        location: String,
        languageCode: String
    )*/
}