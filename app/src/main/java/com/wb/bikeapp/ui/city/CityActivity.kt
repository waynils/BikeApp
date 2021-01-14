package com.wb.bikeapp.ui.city

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import com.wb.bikeapp.Constants.Companion.CONTRACT_KEY
import com.wb.bikeapp.R
import com.wb.bikeapp.core.BaseActivity
import com.wb.bikeapp.databinding.ActivityCityBinding
import com.wb.bikeapp.helper.extensions.startActivityWithBundle
import com.wb.bikeapp.ui.map.MapActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_city.*
import java.util.*

@AndroidEntryPoint
class CityActivity : BaseActivity<CityViewModel, ActivityCityBinding>(R.layout.activity_city) {

    override val viewModel by viewModels<CityViewModel>()

    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        viewModel.liveCityName.observe(this, { listCityName ->
            viewModel.showProgress()
            adapter = ArrayAdapter(this, R.layout.item_city, listCityName)
            dataBinding?.listCity?.adapter = adapter
            viewModel.hideProgress()
        })

        list_city.setOnItemClickListener { adapterView, view, position, l ->
            adapter.getItem(position)?.let { contractName ->
                    startActivityWithBundle<MapActivity>(bundleOf(CONTRACT_KEY to contractName.toLowerCase(Locale.ROOT)), false)

            }
        }
    }


}