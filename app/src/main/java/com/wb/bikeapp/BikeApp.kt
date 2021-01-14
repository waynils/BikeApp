package com.wb.bikeapp

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.uber.rxdogtag.RxDogTag
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BikeApp : Application() {

    override fun onCreate() {
        super.onCreate()

        RxDogTag.install()
        Logger.addLogAdapter(AndroidLogAdapter())

    }

}