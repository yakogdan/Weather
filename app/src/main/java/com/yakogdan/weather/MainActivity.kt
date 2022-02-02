package com.yakogdan.weather

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yakogdan.weather.data.remote.weather.WeatherApi
import com.yakogdan.weather.databinding.ActivityMainBinding
import com.yakogdan.weather.model.forecast.ForecastResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val baseUrl = "https://api.openweathermap.org/data/2.5/"
    val apiKey = "e98a5f2a5a5ca9c353c06b901f89834e"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val retrofit = Retrofit.Builder()
//            .baseUrl(baseUrl) //Базовая часть адреса
//            .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
//            .client(OkHttpClient())
//            .build()
//        val weatherApi = retrofit.create(WeatherApi::class.java)
//        weatherApi.getForecast(
//            cityName = "Moscow",
//            apiKey = apiKey,
//            lang = "ru",
//            units = "metric",
//            cnt = "8"
//        ).enqueue(object : Callback<ForecastResponse> {
//            override fun onResponse(
//                call: Call<ForecastResponse>,
//                response: Response<ForecastResponse>
//            ) {
//                if (response.isSuccessful) {
//                    Log.d("proverka", response.body()?.list.toString())
//                }
//            }
//
//            override fun onFailure(call: Call<ForecastResponse>, t: Throwable) {
//                Log.d("proverka", "Ошибка: ${t.message}")
//            }
//
//        })


        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_three_hours, R.id.navigation_settings
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}