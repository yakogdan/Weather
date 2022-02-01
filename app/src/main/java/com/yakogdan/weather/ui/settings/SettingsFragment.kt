package com.yakogdan.weather.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.yakogdan.weather.adapters.ThreeHoursAdapter
import com.yakogdan.weather.databinding.FragmentSettingsBinding
import com.yakogdan.weather.databinding.FragmentThreeHoursBinding
import com.yakogdan.weather.model.ThreeHoursModel

class SettingsFragment : Fragment() {

    lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {

        }
    }

}