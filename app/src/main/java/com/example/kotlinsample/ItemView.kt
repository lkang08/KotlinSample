package com.example.kotlinsample

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.item_view.view.*

class ItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    init {
        LayoutInflater.from(context).inflate(R.layout.item_view, this, true)
        itemImage.setImageResource(R.mipmap.ic_launcher_round)
        itemTitle.text = "item title"
        itemTitle.setOnClickListener {
            itemImage.setImageResource(R.drawable.icon2)
        }
    }

    fun setTitle(string: String) {
        itemTitle.run {
            text = string
            setTextColor(Color.RED)
        }
        itemImage.setImageResource(R.drawable.icon1)
    }
}