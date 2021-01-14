package com.wb.bikeapp.core

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.wb.bikeapp.R

abstract class BaseMapActivity<VM : BaseViewModel, DB : ViewDataBinding>(@LayoutRes private var contentId: Int) :
    BaseActivity<VM, DB>(contentId) {


    protected abstract val mapView: MapView?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mapViewBundle = savedInstanceState?.getBundle(MAPVIEW_BUNDLE_KEY)

        mapView?.onCreate(mapViewBundle)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY) ?: Bundle().apply {
            putBundle(MAPVIEW_BUNDLE_KEY, this)
        }
        mapView?.onSaveInstanceState(mapViewBundle)
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onPause() {
        mapView?.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        mapView?.onDestroy()
        super.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    companion object {
        private const val MAPVIEW_BUNDLE_KEY = "MapViewBundleKey"
    }
}