package com.example.kotlinsample

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.kotlin.myToast
import kotlinx.android.synthetic.main.activity_kotlin.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton

class KotlinActivity : Activity() {
    private val tag = "System.out"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        var user: User? = User(sex = 0, name = "Kotlin Data User")
        myBtn.setOnClickListener {
            myText.text = user?.name
            Log.d(tag, "user ${user?.name} sex  ${user?.sex}")
            myText.textSize = resources.getDimension(R.dimen.sp18)
            myText.setTextColor(resources.getColor(R.color.colorPrimary, null))
            initRecyclerView()
        }
        toastBtn.setOnClickListener {
            extensionFunction(user)
        }
        ankoBtn.setOnClickListener {
            anko()
        }
    }

    private fun initRecyclerView() {
        var adapter = MyAdapter()
        adapter.data = initData()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun extensionFunction(user: User?) {
        myToast("myToast from activity extension function")
    }

    private fun anko() {
        alert("message", "title") {
            yesButton { toast("yes") }
            noButton { toast("no") }
        }.show()
    }

    private fun initData(): List<User> {
        var list = mutableListOf<User>()
        for (i in 1..10) {
            list.add(User(name = "Name $i", sex = if (i % 2 == 0) 0 else 1, description = "User description $i "))
        }
        return list
    }
}