package com.yakogdan.weather.data.remote.weather

import com.yakogdan.weather.model.forecast.ForecastResponse
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

}