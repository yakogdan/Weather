package com.yakogdan.weather.model.forecast

class ForecastResponse(
    val cod: String,
    val message: Int,
    val cnt: Int,
    val city: City,
    val list: List<ListItem>
)