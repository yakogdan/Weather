package com.yakogdan.weather.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.yakogdan.weather.adapters.ThreeHoursAdapter
import com.yakogdan.weather.databinding.FragmentHomeBinding
import com.yakogdan.weather.ui.threehours.ThreeHoursViewModel

class HomeFragment : Fragment() {

    private lateinit var bindingHome: FragmentHomeBinding

    private val threeHoursAdapter = ThreeHoursAdapter()
    private val threeHoursViewModel: ThreeHoursViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingHome = FragmentHomeBinding.inflate(inflater)
        return bindingHome.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindingHome.apply {

        }
    }
}