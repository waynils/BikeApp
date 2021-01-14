package com.wb.bikeapp.repositories

import androidx.lifecycle.LiveData
import com.wb.bikeapp.helper.extensions.toLiveData
import com.wb.bikeapp.models.StationDetailModel
import com.wb.bikeapp.models.StationModel
import com.wb.bikeapp.models.toStationDetailModel
import com.wb.bikeapp.models.toStationModel
import com.wb.bikeapp.remote.bike.BikeApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BikeRepositoryImpl @Inject constructor(private val bikeApiService: BikeApiService) : BikeRepository {


    override fun getContracts(): LiveData<List<String>> {
        return bikeApiService.getContracts().map { contracts ->
            contracts.map { contract ->
                contract.name
            }
        }.subscribeOn(Schedulers.io()).toLiveData()
    }

    override fun getStationsFromContract(nameContract: String): LiveData<List<StationModel>> {
        return bikeApiService.getStationsFromContract(nameContract).map { stations ->
            stations.map { station ->
                station.toStationModel()
            }
        }.subscribeOn(Schedulers.io()).toLiveData()
    }

    override fun getStationDetail(stationNumber: Int, nameContract: String): LiveData<StationDetailModel> {
        return bikeApiService.getStationDetail(stationNumber, nameContract).map { stationDetailResponse ->
            stationDetailResponse.toStationDetailModel()
        }.subscribeOn(Schedulers.io()).toLiveData()
    }


}