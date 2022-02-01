package com.yakogdan.weather.ui.threehours

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yakogdan.weather.adapters.ThreeHoursAdapter
import com.yakogdan.weather.databinding.FragmentThreeHoursBinding
import com.yakogdan.weather.model.ThreeHoursModel

class ThreeHoursFragment : Fragment() {

    lateinit var binding: FragmentThreeHoursBinding

    private val threeHoursAdapter = ThreeHoursAdapter(getData())

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
        }
    }

    private fun getData() = listOf<ThreeHoursModel>(
        ThreeHoursModel(
            "2022-02-01 00:00:00",
            "-1.54",
            "небольшой снег"
        ),
        ThreeHoursModel(
            "2022-02-01 3:00:00",
            "-2.54",
            "большой снег"
        ),
        ThreeHoursModel(
            "2022-02-01 6:00:00",
            "-3.74",
            "средний снег"
        ),
        ThreeHoursModel(
            "2022-02-01 9:00:00",
            "-2.82",
            "снег"
        )
    )
}