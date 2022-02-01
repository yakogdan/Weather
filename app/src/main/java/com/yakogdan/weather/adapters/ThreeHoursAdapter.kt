package com.yakogdan.weather.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yakogdan.weather.R
import com.yakogdan.weather.databinding.ItemThreeHoursBinding
import com.yakogdan.weather.model.ThreeHoursModel

class ThreeHoursAdapter(private val threeHoursModel: List<ThreeHoursModel>) : RecyclerView.Adapter<ThreeHoursAdapter.ThreeHoursViewHolder>() {

    inner class ThreeHoursViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemThreeHoursBinding.bind(view)

        fun bind(threeHoursModel: ThreeHoursModel) = with(binding) {
            tvDate.text = threeHoursModel.dt_txt
            tvTemp.text = threeHoursModel.temp
            tvDescription.text = threeHoursModel.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThreeHoursViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        return ThreeHoursViewHolder(inflater.inflate(R.layout.item_three_hours,parent,false))
    }

    override fun onBindViewHolder(holder: ThreeHoursViewHolder, position: Int) {
        holder.bind(threeHoursModel[position])
    }

    override fun getItemCount(): Int = threeHoursModel.size
}