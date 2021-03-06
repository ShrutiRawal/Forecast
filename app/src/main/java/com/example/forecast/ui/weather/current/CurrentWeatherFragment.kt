package com.example.forecast.ui.weather.current

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.forecast.R
import com.example.forecast.data.network.ApixuWeatherApiService
import com.example.forecast.data.network.ConnectivityInterceptorImpl
import com.example.forecast.data.network.WeatherNetworkDataSource
import com.example.forecast.data.network.WeatherNetworkDataSourceImpl
import com.example.forecast.ui.base.ScopedFragment
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class CurrentWeatherFragment : ScopedFragment(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactory: CurrentWeatherViewModelFactory by instance()


    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(CurrentWeatherViewModel::class.java)
        bindUI()

    }

    private fun bindUI() = GlobalScope.launch() {
        val currentWeather = viewModel.weather.await()
        Handler(Looper.getMainLooper()).post {
            currentWeather.observe(this@CurrentWeatherFragment, Observer {
                if(it==null) return@Observer

                current.text = it.toString()
            })
        }
        /*
        GlobalScope.launch(Dispatchers.Main) {
            currentWeather.observe(this@CurrentWeatherFragment, Observer {
                if (it == null){
                    return@Observer
                } else{
                    current.text = it.toString()
                }
            })
        }*/

    }

}
