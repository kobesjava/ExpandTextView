package com.jaki.expand.extension

import android.content.res.Resources
import android.util.TypedValue

fun Float.dp2px(): Int {
    if (this == 0.0f) return 0
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics).toInt()
}

fun Int.dp2px(): Int {
    return this.toFloat().dp2px()
}