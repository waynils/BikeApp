package com.wb.bikeapp.remote.bike

import com.orhanobut.logger.Logger
import com.wb.bikeapp.remote.ApiRemoteImpl
import com.wb.bikeapp.remote.bike.response.Contract
import com.wb.bikeapp.remote.bike.response.Station
import com.wb.bikeapp.remote.bike.response.StationDetailResponse
import com.wb.bikeapp.remote.exceptions.ServerErrorException
import io.reactivex.Single
import io.reactivex.SingleEmitter
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BikeApiServiceImpl @Inject constructor(retrofit: Retrofit) : BikeApiService, ApiRemoteImpl() {

    private val bikeApiService: BikeApi = retrofit.create(BikeApi::class.java)

    override fun getContracts(): Single<List<Contract>> = Single.create { emitter ->
        bikeApiService.getContracts()
            .subscribeResponse(emitter)
    }

    override fun getStationsFromContract(contract: String):Single<List<Station>> = Single.create { emitter ->
        bikeApiService.getStationsFromContract(contract)
            .subscribeResponse(emitter)
    }

    override fun getStationDetail(stationNumber: Int, contract: String): Single<StationDetailResponse> = Single.create { emitter ->
        bikeApiService.getStationDetail(stationNumber, contract)
            .subscribeResponse(emitter)
    }

    private fun <T : Any, V : Any> Single<T>.subscribeResponse(emitter: SingleEmitter<V>): Disposable {
        return this.subscribeBy(
            onSuccess = { response ->
                if ((response as Response<V>).isSuccessful) {
                    response.body()?.let { data ->
                        emitter.onSuccess(data)
                    }
                } else {
                    handleStatusCodeToSendEmitter(emitter, response.code())
                }
            }
        )
    }


}