package com.wb.bikeapp.ui.splashscreen

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.orhanobut.logger.Logger
import com.wb.bikeapp.R
import com.wb.bikeapp.core.BaseActivity
import com.wb.bikeapp.databinding.ActivitySplashBinding
import com.wb.bikeapp.helper.extensions.startActivity
import com.wb.bikeapp.ui.city.CityActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenActivity : BaseActivity<SplashScreenViewModel, ActivitySplashBinding>(R.layout.activity_splash) {

    override val viewModel by viewModels<SplashScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.liveLoadFakeDataCompleted.observe(this, Observer {
            startActivity<CityActivity>()
        })
    }


}