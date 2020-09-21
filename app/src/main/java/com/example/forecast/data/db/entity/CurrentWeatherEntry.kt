package com.example.forecast.data.db.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CURRENT_WEATHER_ID = 0

@Entity(tableName = "current_weather")
data class CurrentWeatherEntry(
    val temperature: Double,
    @SerializedName("weather_code")
    val weatherCode: Int,
    @SerializedName("wind_speed")
    val windSpeed: Double,
    @SerializedName("wind_degree")
    val windDegree: Double,
    @SerializedName("wind_dir")
    val windDir: String,
    val precip: Double,
    val feelslike: Double,
    val visibility: Double,
    @SerializedName("is_day")
    val isDay: String
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_WEATHER_ID
}