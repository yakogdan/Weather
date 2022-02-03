package com.yakogdan.weather.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yakogdan.weather.data.remote.weather.WeatherRepository
import com.yakogdan.weather.model.weather.WeatherResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel : ViewModel() {

    private val HomeCompositeDisposable = CompositeDisposable()
    private val apiKey = "e98a5f2a5a5ca9c353c06b901f89834e"
    private val weatherRepository = WeatherRepository()

    val weatherLiveData: MutableLiveData<WeatherResponse> = MutableLiveData()

    fun fetchWeather() {
        HomeCompositeDisposable.add(weatherRepository.getWeather(apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                weatherLiveData.value = it
            }, {
                Log.e("Error weather", it.message.toString())
            }))
    }
}


