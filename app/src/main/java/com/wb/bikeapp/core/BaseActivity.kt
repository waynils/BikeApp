package com.wb.bikeapp.core

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.wb.bikeapp.BR
import com.wb.bikeapp.helper.ActivityStateHelper
import java.util.Observer

abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding>(@LayoutRes private var contentId: Int) :
    ActivityStateHelper() {

    abstract val viewModel: VM

    protected var dataBinding: DB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil
            .setContentView<DB>(this, contentId)
            .apply {
                dataBinding = this
                lifecycleOwner = this@BaseActivity
                setVariable(BR.vm, viewModel)
            }

        (viewModel as BaseViewModel).liveShowProgress.observe(this, {
            if(it) showProgressDialog() else hideProgressDialog()
        })

    }


}