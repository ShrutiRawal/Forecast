package com.example.forecast.data.repository

import androidx.lifecycle.LiveData
import com.example.forecast.data.db.unitlocalised.unitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out unitSpecificCurrentWeatherEntry>

}