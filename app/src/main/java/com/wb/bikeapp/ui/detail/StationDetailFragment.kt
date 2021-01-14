package com.wb.bikeapp.ui.detail

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.wb.bikeapp.databinding.DialogBottomStationDetailBinding
import com.wb.bikeapp.models.StationModel
import com.wb.bikeapp.ui.map.MapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StationDetailFragment : BottomSheetDialogFragment() {

    private val viewModel by viewModels<StationDetailViewModel>()

    private val activityViewModel by activityViewModels<MapViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun show(activity: AppCompatActivity, tag: String? = null) {
        super.show(activity.supportFragmentManager, tag)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DialogBottomStationDetailBinding
            .inflate(inflater, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
                vm = viewModel
                activityVM = activityViewModel
            }
            .root
    }

    companion object {
        fun newInstance() = StationDetailFragment()
    }
}