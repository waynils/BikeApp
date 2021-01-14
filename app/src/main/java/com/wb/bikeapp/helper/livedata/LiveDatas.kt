package com.wb.bikeapp.helper.livedata

import android.os.Looper
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean


fun <T> MutableLiveData<T>.changeValue(value: T?) = if (Looper.getMainLooper() == Looper.myLooper()) {
    setValue(value)
} else {
    postValue(value)
}

