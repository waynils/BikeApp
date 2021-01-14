package com.wb.bikeapp.ui.map

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.switchMap
import com.wb.bikeapp.Constants
import com.wb.bikeapp.core.BaseViewModel
import com.wb.bikeapp.helper.livedata.changeValue
import com.wb.bikeapp.models.StationModel
import com.wb.bikeapp.repositories.BikeRepository

class MapViewModel @ViewModelInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    private val bikeRepository: BikeRepository
) : BaseViewModel() {

    val liveStations: LiveData<List<StationModel>> =
        savedStateHandle.getLiveData<String>(Constants.CONTRACT_KEY).switchMap { nameContract ->
            bikeRepository.getStationsFromContract(nameContract)
        }
    private val stationSelected = MutableLiveData<StationModel>()

    var liveShowStation = stationSelected.switchMap {
        val stationDetail = bikeRepository.getStationDetail(it.number, it.contractName)
        hideProgress()
        stationDetail
    }

    fun onStationSelected(stationModel: StationModel) {
        showProgress()
        stationSelected.changeValue(stationModel)
    }

}