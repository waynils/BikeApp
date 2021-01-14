package com.wb.bikeapp.models

import com.google.android.gms.maps.model.LatLng
import com.wb.bikeapp.Constants

data class StationDetailModel(val number: Int,
                              val name: String,
                              val latLng: LatLng,
                              val banking: Boolean,
                              val bonus: Boolean,
                              val status: Constants.StationStatus,
                              val address:String,
                              val bikeAvailable: Int,
                              val electricalBikeAvailable: Int,
                              val standAvailable: Int)