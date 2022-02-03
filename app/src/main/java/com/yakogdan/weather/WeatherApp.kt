package com.yakogdan.weather

import android.app.Application
import com.yakogdan.weather.data.remote.weather.WeatherApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class WeatherApp: Application() {

    private val baseUrl = "https://api.openweathermap.org/data/2.5/"
    private val apiKey = "e98a5f2a5a5ca9c353c06b901f89834e"
    val weatherApi: WeatherApi by lazy { configureRetrofit() }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    private fun configureRetrofit(): WeatherApi {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit.create(WeatherApi::class.java)
    }

    companion object {
        lateinit var instance: WeatherApp
    }
}