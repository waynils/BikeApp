package com.wb.bikeapp.models

import com.google.android.gms.maps.model.LatLng
import com.wb.bikeapp.Constants
import java.io.Serializable

data class StationModel(val number: Int,
                        val contractName:String,
                        val latLng: LatLng,
                        val banking: Boolean,
                        val bonus: Boolean,
                        val status: Constants.StationStatus,
                        val bikeAvailable: Int,
                        val standAvailable: Int): Serializable