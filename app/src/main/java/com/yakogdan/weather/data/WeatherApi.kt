package com.yakogdan.weather.data

import com.yakogdan.weather.model.forecast.ForecastResponse
import com.yakogdan.weather.model.weather.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast")
    fun getForecast(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String,
        @Query("lang") lang: String,
        @Query("units") units: String,
        @Query("cnt") cnt: String
    ): Single<ForecastResponse>

    @GET("weather")
    fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String,
        @Query("lang") lang: String,
        @Query("units") units: String
    ): Single<WeatherResponse>

}