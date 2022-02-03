package com.yakogdan.weather.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yakogdan.weather.R
import com.yakogdan.weather.databinding.ItemThreeHoursBinding
import com.yakogdan.weather.model.forecast.ListItem

class ThreeHoursAdapter : RecyclerView.Adapter<ThreeHoursAdapter.ThreeHoursViewHolder>() {

    private var data: List<ListItem> = emptyList()

    inner class ThreeHoursViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemThreeHoursBinding.bind(view)

        @SuppressLint("SetTextI18n")
        fun bind(listItem: ListItem) = with(binding) {
            tvDate.text = listItem.dtTxt
            tvTemp.text = listItem.main.temp.toInt().toString() + "°"
            tvDescription.text = listItem.weather[0].description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThreeHoursViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        return ThreeHoursViewHolder(inflater.inflate(R.layout.item_three_hours,parent,false))
    }

    override fun onBindViewHolder(holder: ThreeHoursViewHolder, position: Int) {
        holder.bind(data[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(items: List<ListItem>) {
        data = items
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size
}