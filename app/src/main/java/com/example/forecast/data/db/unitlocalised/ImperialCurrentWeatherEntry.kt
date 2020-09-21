package com.example.forecast.data.db.unitlocalised

import androidx.room.ColumnInfo

data class ImperialCurrentWeatherEntry(
    override val temperature: Double,
    override val weatherCode: Int,
    override val windSpeed: Double,
    override val windDegree: Double,
    override val windDir: String,
    override val precip: Double,
    override val feelslike: Double,
    override val visibility: Double,
    override val isDay: String
): unitSpecificCurrentWeatherEntry