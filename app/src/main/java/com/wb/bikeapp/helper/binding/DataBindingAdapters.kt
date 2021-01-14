package com.wb.bikeapp.helper.binding

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import androidx.databinding.BindingAdapter
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.wb.bikeapp.BR
import com.wb.bikeapp.databinding.ItemStationBinding
import com.wb.bikeapp.helper.extensions.getMarkerBitmapFromView
import com.wb.bikeapp.models.StationModel


interface OnMarkerSelectedListener {
    fun onStationSelected(station: StationModel)
}

@SuppressLint("PotentialBehaviorOverride")
@BindingAdapter("app:initMap", "app:onStationSelected", requireAll = false)
fun MapView.initMap(listStation: List<StationModel>?, listener: OnMarkerSelectedListener?) {
    listStation?.let {
        getMapAsync { map ->
            map?.apply {
                animateCamera(CameraUpdateFactory.newLatLngZoom(listStation[0].latLng, 13.0F))
                listStation.forEachIndexed { index,  station ->
                    addMarker(
                        MarkerOptions().position(station.latLng)
                            .icon(BitmapDescriptorFactory.fromBitmap(createStationMarker(context, station)))

                    ).tag = station
                }
                map.setOnMarkerClickListener {
                    listener?.onStationSelected(it.tag as StationModel)
                    false
                }
            }
        }
    }
}

private fun createStationMarker(context: Context, station: StationModel): Bitmap {
    val inflater = (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
    val binding = ItemStationBinding.inflate(inflater)
    binding.station = station
    binding.setVariable(BR.station, station)
    binding.executePendingBindings()
    return binding.root.getMarkerBitmapFromView()
}