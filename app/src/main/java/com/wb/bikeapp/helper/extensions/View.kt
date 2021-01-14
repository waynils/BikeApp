package com.wb.bikeapp.helper.extensions

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View

fun View.getMarkerBitmapFromView(): Bitmap {
    measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
    val bitmap =
        Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    layout(0, 0, measuredWidth, measuredHeight)
    draw(canvas)
    return bitmap
}