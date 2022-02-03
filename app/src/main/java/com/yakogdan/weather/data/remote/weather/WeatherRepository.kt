package com.yakogdan.weather.data.remote.weather

import com.yakogdan.weather.WeatherApp

class WeatherRepository {

    private val weatherApi: WeatherApi = WeatherApp.instance.weatherApi

    fun getForecast(apiKey: String) = weatherApi.getForecast(cityName = "Moscow", apiKey = apiKey, lang = "ru", units = "metric", cnt = "20")
    fun getWeather(apiKey: String) = weatherApi.getWeather(cityName = "Moscow", apiKey = apiKey, lang = "ru", units = "metric")
}