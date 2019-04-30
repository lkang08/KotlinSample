package com.example.kotlinsample

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.kotlin.format
import com.example.kotlin.print
import kotlinx.android.synthetic.main.activity_kotlin.*

class KotlinActivity : Activity() {
    private val tag = "System.out"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        var user: User? = User(sex = 0, name = "aaa")
        myBtn.setOnClickListener {
            myText.text = user?.name
            Log.d(tag, "user ${user?.name} sex  ${user?.sex}")
            user?.name?.print()
            Log.d(tag, user?.name?.format())
            myText.textSize = resources.getDimension(R.dimen.sp20)
            myText.setTextColor(resources.getColor(R.color.colorPrimary, null))
        }
        var adapter = MyAdapter()
        adapter.data = initData()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun initData(): List<User> {
        var list = mutableListOf<User>()
        list.add(User(name = "Name 1", sex = 0, description = "my description0 "))
        list.add(User(name = "Name 2", sex = 1, description = "my description1 "))
        list.add(User(name = "Name 3", sex = 1, description = "my description2 "))
        list.add(User(name = "Name 4", sex = 0, description = "my description3 "))
        list.add(User(name = "Name 5", sex = 0, description = "my description4"))
        return list
    }
}