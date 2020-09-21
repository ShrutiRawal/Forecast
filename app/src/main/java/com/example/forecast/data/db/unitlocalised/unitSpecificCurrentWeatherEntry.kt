package com.example.forecast.data.db.unitlocalised

interface unitSpecificCurrentWeatherEntry {
    val temperature: Double
    val weatherCode: Int
    val windSpeed: Double
    val windDegree: Double
    val windDir: String
    val precip: Double
    val feelslike: Double
    val visibility: Double
    val isDay: String
}