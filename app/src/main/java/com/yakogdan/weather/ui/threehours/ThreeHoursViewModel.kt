package com.yakogdan.weather.ui.threehours

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yakogdan.weather.data.WeatherRepository
import com.yakogdan.weather.model.forecast.ForecastResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ThreeHoursViewModel : ViewModel() {

    private val threeHoursCompositeDisposable = CompositeDisposable()
    private val apiKey = "e98a5f2a5a5ca9c353c06b901f89834e"
    private val weatherRepository = WeatherRepository()

    val forecastLiveData: MutableLiveData<ForecastResponse> = MutableLiveData()

    fun fetchForecast() {
        threeHoursCompositeDisposable.add(weatherRepository.getForecast(apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ forecastData ->
                forecastLiveData.value = forecastData
            }, {
                Log.e("Error forecast", it.message.toString())
            }))
    }

    override fun onCleared() {
        threeHoursCompositeDisposable.dispose()
        super.onCleared()
    }
}

