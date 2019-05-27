package com.example.kotlin

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.widget.Toast

inline fun Context.myToast(message: CharSequence, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration).show()
}

fun withMethod() {
    var paint = Paint()
    paint.color = Color.BLACK
    paint.strokeWidth = 1.0f
    paint.textSize = 18.0f
    paint.isAntiAlias = true

    var paint2 = with(paint) {
        color = Color.BLACK
        strokeWidth = 1.0f
        textSize = 18.0f
        isAntiAlias = true
        this
    }

}
