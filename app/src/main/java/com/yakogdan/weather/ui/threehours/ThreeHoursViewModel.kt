package com.yakogdan.weather.ui.threehours

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.yakogdan.weather.data.remote.weather.WeatherApi
import com.yakogdan.weather.model.forecast.ForecastResponse
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ThreeHoursViewModel(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()
    val apiKey = "e98a5f2a5a5ca9c353c06b901f89834e"

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun fetchForecast(weatherApi: WeatherApi?) {
        weatherApi?.let {
            compositeDisposable.add(weatherApi.getForecast(cityName = "Moscow", apiKey = apiKey, lang = "ru", units = "metric", cnt = "8")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                }, {

                }))
        }
    }

}

private fun CompositeDisposable.add(forecast: Single<ForecastResponse>) {
    TODO("Not yet implemented")
}
