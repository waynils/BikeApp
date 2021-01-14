package com.wb.bikeapp.ui.splashscreen

import androidx.hilt.lifecycle.ViewModelInject
import com.wb.bikeapp.core.BaseViewModel
import com.wb.bikeapp.helper.livedata.SingleLiveEvent
import com.wb.bikeapp.helper.livedata.call
import io.reactivex.Observable
import io.reactivex.rxkotlin.addTo
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashScreenViewModel @ViewModelInject constructor() : BaseViewModel() {

    val liveLoadFakeDataCompleted = SingleLiveEvent<Unit>()

    init {
        Observable.timer(4, TimeUnit.SECONDS)
            .subscribe {
                liveLoadFakeDataCompleted.call()
            }.addTo(compositeDisposable)
    }


}