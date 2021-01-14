package com.wb.bikeapp.ui.map

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.google.android.gms.maps.MapView
import com.orhanobut.logger.Logger
import com.wb.bikeapp.R
import com.wb.bikeapp.core.BaseMapActivity
import com.wb.bikeapp.databinding.ActivityMapBinding
import com.wb.bikeapp.ui.detail.StationDetailFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MapActivity : BaseMapActivity<MapViewModel, ActivityMapBinding>(R.layout.activity_map) {

    override val viewModel by viewModels<MapViewModel>()

    override val mapView: MapView? get() = dataBinding?.map

    lateinit var bottomStationDetailFragment: StationDetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottomStationDetailFragment = StationDetailFragment.newInstance()

        viewModel.liveShowStation.observe(this, {
            bottomStationDetailFragment.show(this)
        })
    }

}