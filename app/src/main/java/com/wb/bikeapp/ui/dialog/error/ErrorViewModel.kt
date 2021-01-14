package com.wb.bikeapp.ui.dialog.error

import androidx.databinding.ObservableField
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.wb.bikeapp.helper.livedata.SingleLiveEvent

class ErrorViewModel @ViewModelInject constructor() : ViewModel() {

    val message = ObservableField<String>()

    val actionEvent = SingleLiveEvent<Boolean>()

    fun init(message: String) {
        this.message.set(message)
    }

    fun performAction(ok: Boolean) {
        actionEvent.value = ok
    }
}