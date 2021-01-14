package com.wb.bikeapp.models

import com.google.android.gms.maps.model.LatLng
import com.wb.bikeapp.Constants
import com.wb.bikeapp.remote.bike.response.Station
import com.wb.bikeapp.remote.bike.response.StationDetailResponse


fun Station.toStationModel(): StationModel {
    return StationModel(
        number,
        contractName,
        LatLng(position.latitude, position.longitude),
        banking,
        bonus,
        Constants.StationStatus.from(status),
        mainStands.availabilities.bikes,
        mainStands.availabilities.stands
    )
}

fun StationDetailResponse.toStationDetailModel(): StationDetailModel {
    return StationDetailModel(
        number,
        name,
        LatLng(position.latitude, position.longitude),
        banking,
        bonus,
        Constants.StationStatus.from(status),
        address,
        mainStands.availabilities.bikes,
        mainStands.availabilities.electricalBikes,
        mainStands.availabilities.stands
    )
}
