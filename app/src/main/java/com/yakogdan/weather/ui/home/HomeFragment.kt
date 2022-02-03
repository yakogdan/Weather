package com.yakogdan.weather.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.yakogdan.weather.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var bindingHome: FragmentHomeBinding

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingHome = FragmentHomeBinding.inflate(inflater)
        return bindingHome.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        homeViewModel.weatherLiveData.observe(viewLifecycleOwner) { weatherData ->
            bindingHome.tvLocation.text = weatherData.name
            bindingHome.homeTemp.text = weatherData.main.temp.toInt().toString() + "°"
            bindingHome.homeDescription.text = weatherData.weather[0].description
            bindingHome.tempMax.text = "max " + weatherData.main.tempMax.toInt().toString() + "°"
            bindingHome.tempMin.text = "min " + weatherData.main.tempMin.toInt().toString() + "°"
        }
        homeViewModel.fetchWeather()
    }
}