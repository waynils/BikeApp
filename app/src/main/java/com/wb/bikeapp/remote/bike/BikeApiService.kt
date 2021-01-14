package com.wb.bikeapp.remote.bike

import com.wb.bikeapp.remote.bike.response.*
import io.reactivex.Single
import retrofit2.Response

interface BikeApiService {

    fun getContracts(): Single<List<Contract>>
    fun getStationsFromContract(contract: String): Single<List<Station>>
    fun getStationDetail(stationNumber: Int, contract: String): Single<StationDetailResponse>

}