package com.wb.bikeapp.ui.shared

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.PluralsRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.wb.bikeapp.R
import com.wb.bikeapp.databinding.NumberBikeViewBinding

class NumberBikeView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attrs) {

    val binding = NumberBikeViewBinding.inflate(LayoutInflater.from(context), this, true)


    init {

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.NumberBikeView, defStyleAttr, 0)

        typedArray.getResourceId(R.styleable.NumberBikeView_img, R.drawable.ic_bike).let {
            binding.icon.setImageResource(it)
        }
        typedArray.getResourceId(R.styleable.NumberBikeView_color, Color.BLACK).let {
            ContextCompat.getColorStateList(context, it).apply {
                binding.description.backgroundTintList = this
                binding.icon.imageTintList = this
            }

        }

        typedArray.recycle()

    }
}


@BindingAdapter("app:plural", "app:quantity", requireAll = true)
fun NumberBikeView.setText(@PluralsRes resourceId: Int, quantity: Int) {
    this.binding.description.text = context.resources.getQuantityString(resourceId, quantity, quantity)
}
