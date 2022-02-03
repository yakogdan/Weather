package com.yakogdan.weather.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.yakogdan.weather.adapters.ThreeHoursAdapter
import com.yakogdan.weather.databinding.FragmentHomeBinding
import com.yakogdan.weather.ui.threehours.ThreeHoursViewModel

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        homeViewModel.weatherLiveData.observe(viewLifecycleOwner) { weatherData ->
            bindingHome.homeTemp.text = weatherData.main.temp.toString()
            bindingHome.homeDescription.text = weatherData.weather[0].description
            bindingHome.tempMax.text = weatherData.main.tempMax.toString()
            bindingHome.tempMin.text = weatherData.main.tempMin.toString()
        }
        homeViewModel.fetchWeather()
    }
}