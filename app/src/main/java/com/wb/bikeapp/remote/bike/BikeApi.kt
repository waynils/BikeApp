package com.wb.bikeapp.remote.bike

import com.wb.bikeapp.remote.bike.response.*
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BikeApi {

    @GET("vls/v3/contracts")
    fun getContracts(): Single<Response<List<Contract>>>

    @GET("vls/v3/stations?")
    fun getStationsFromContract(@Query("contract") contract: String): Single<Response<List<Station>>>

    @GET("vls/v3/stations/{station_number}?")
    fun getStationDetail(@Path("station_number") stationNumber: Int,
                         @Query("contract") contract: String): Single<Response<StationDetailResponse>>

}