package com.example.kotlin

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.net.Uri
import android.webkit.WebView
import android.widget.Toast

inline fun Context.myToast(message: CharSequence, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration).show()
}

inline fun String.isUpCase(): Boolean {
    return this.toUpperCase() == this
}

fun method(webView: WebView) {
    //1
    with(webView.settings) {
        javaScriptEnabled = true
        databaseEnabled = true
    }

    webView.settings.run {
        javaScriptEnabled = true
        databaseEnabled = true
    }

    with(webView.settings) {
        this?.javaScriptEnabled = true
        this?.databaseEnabled = true
    }

    webView.settings?.run {
        javaScriptEnabled = true
        databaseEnabled = true
    }

    //2 this it
    webView.settings.let {
        it.javaScriptEnabled = true
        it.databaseEnabled = true
    }
    webView.settings.apply {
        javaScriptEnabled = true
        databaseEnabled = true
    }


    //3 return type
    webView.settings.let {
        it.javaScriptEnabled = true
        it.databaseEnabled = true
        "abc"
    }.let {
        it.length
    }

    webView.settings.also {
        it.javaScriptEnabled = true
    }.also {
        it.databaseEnabled = true
    }
}

fun withMethod() {
    var paint = Paint()
    paint.color = Color.BLACK
    paint.strokeWidth = 1.0f
    paint.textSize = 18.0f
    paint.isAntiAlias = true

    var paint2 = with(Paint()) {
        color = Color.BLACK
        strokeWidth = 1.0f
        textSize = 18.0f
        isAntiAlias = true
    }
}

fun createIntent(intentData: String, intentAction: String): Intent {
    val intent = Intent()
    intent.action = intentAction
    intent.data = Uri.parse(intentData)
    return intent
}

fun createIntent2(intentData: String, intentAction: String) =
    Intent().apply { action = intentAction }
        .apply { data = Uri.parse(intentData) }

fun createIntent3(intentData: String, intentAction: String) =
    Intent().also { it.action = intentAction }
        .also { it.data = Uri.parse(intentData) }
