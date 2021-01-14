package com.wb.bikeapp.ui.city

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.map
import com.wb.bikeapp.core.BaseViewModel
import com.wb.bikeapp.repositories.BikeRepository

class CityViewModel @ViewModelInject constructor(bikeRepository: BikeRepository) : BaseViewModel() {

    val liveCityName = bikeRepository.getContracts().map { listCity ->
        listCity.map { city ->
            city.capitalize()
        }.sorted()
    }


}