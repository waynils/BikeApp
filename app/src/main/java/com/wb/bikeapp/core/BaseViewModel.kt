package com.wb.bikeapp.core

import androidx.lifecycle.ViewModel
import com.wb.bikeapp.helper.livedata.SingleLiveEvent
import com.wb.bikeapp.helper.livedata.changeValue
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected var compositeDisposable = CompositeDisposable()

    val liveShowProgress = SingleLiveEvent<Boolean>()

    fun showProgress() = liveShowProgress.changeValue(true)

    fun hideProgress() = liveShowProgress.changeValue(false)

    override fun onCleared() {
        super.onCleared()
        disposComposite()
    }

    protected fun disposComposite() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}