package com.example.forecast.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.forecast.data.network.response.CurrentWeatherResponse
import com.example.forecast.internal.NoConnectivityException

 class WeatherNetworkDataSourceImpl(
    private val apixuWeatherApiService: ApixuWeatherApiService
) : WeatherNetworkDataSource {

    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

     override suspend fun fetchCurrentWeather(location: String) {
        try {
            val fetchedCurrentWeather = apixuWeatherApiService
                .getCurrentWeather(location)
                .await()
            _downloadedCurrentWeather.postValue(fetchedCurrentWeather)
        }
        catch (e: NoConnectivityException) {
            Log.e("Connectivity", "No internet connection.", e)
        }
    }

    /* private val _downloadedFutureWeather = MutableLiveData<FutureWeatherResponse>()
     override val downloadedFutureWeather: LiveData<FutureWeatherResponse>
         get() = _downloadedFutureWeather

     override suspend fun fetchFutureWeather(
         location: String,
         languageCode: String
     ) {
         try {
             val fetchedFutureWeather = apixuWeatherApiService
                 .getFutureWeather(location, FORECAST_DAYS_COUNT, languageCode)
                 .await()
             _downloadedFutureWeather.postValue(fetchedFutureWeather)
         }
         catch (e: NoConnectivityException) {
             Log.e("Connectivity", "No internet connection.", e)
         }
     }*/
}