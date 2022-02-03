package com.yakogdan.weather.ui.threehours

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.yakogdan.weather.adapters.ThreeHoursAdapter
import com.yakogdan.weather.databinding.FragmentThreeHoursBinding
import com.yakogdan.weather.decoration.DividerDecoration

class ThreeHoursFragment : Fragment() {

    private lateinit var binding: FragmentThreeHoursBinding

    private val threeHoursAdapter = ThreeHoursAdapter()
    private val threeHoursViewModel: ThreeHoursViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThreeHoursBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            rvFragmentThreeHours.adapter = threeHoursAdapter
            rvFragmentThreeHours.addItemDecoration(DividerDecoration(0, 0, 0, 20))
        }
        threeHoursViewModel.forecastLiveData.observe(viewLifecycleOwner) {
            threeHoursAdapter.setData(it.list)
        }
        threeHoursViewModel.fetchForecast()
    }


}