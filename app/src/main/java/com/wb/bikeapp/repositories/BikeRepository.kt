package com.wb.bikeapp.repositories

import androidx.lifecycle.LiveData
import com.wb.bikeapp.models.StationDetailModel
import com.wb.bikeapp.models.StationModel

interface BikeRepository {

    fun getContracts(): LiveData<List<String>>
    fun getStationsFromContract(nameContract: String): LiveData<List<StationModel>>
    fun getStationDetail(stationNumber: Int, nameContract: String): LiveData<StationDetailModel>
}