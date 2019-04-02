package com.example.kotlinsample

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_kotlin.*

class KotlinActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        myBtn.setOnClickListener {
            myText.text = "Hello Kotlin!"
            myText.textSize = resources.getDimension(R.dimen.sp20)
            myText.setTextColor(resources.getColor(R.color.colorPrimary, null))
        }
    }
}