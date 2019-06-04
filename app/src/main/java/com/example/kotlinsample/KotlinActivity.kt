package com.example.kotlinsample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.example.kotlin.myToast
import com.example.kotlin.testWith
import kotlinx.android.synthetic.main.activity_kotlin.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton

class KotlinActivity : FragmentActivity() {
    private val tag = "System.out"
    private var fragment: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        var user: User? = User(sex = 0, name = "Kotlin Data User")
        mButton.setOnClickListener {
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
        testWith()

        initFragment()
    }

    private fun initRecyclerView() {
        var adapter = MyAdapter()
        adapter.data = initData()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun onClickFunction() {
        //final
        mButton.setOnClickListener {
            it.visibility = View.GONE
        }

        //step 0
        mButton.setOnClickListener(View.OnClickListener { view: View ->
            view.visibility = View.GONE
        })

        //step pic1
        mButton.setOnClickListener({ view: View ->
            view.visibility = View.GONE
        })

        //step 2
        mButton.setOnClickListener() { view: View ->
            view.visibility = View.GONE
        }

        //step 3
        mButton.setOnClickListener { view: View ->
            view.visibility = View.GONE
        }

        //step 4
        mButton.setOnClickListener { view ->
            view.visibility = View.GONE
        }

        //step 5
        mButton.setOnClickListener {
            it.visibility = View.GONE
        }
    }

    private fun extensionFunction(user: User?) {
        myToast("myToast from activity extension collectionMethod")
    }

    private fun anko() {
        alert("message", "title") {
            yesButton { toast("yes") }
            noButton { toast("no") }
        }.show()
    }

    private fun initFragment() {
        fragment = KotlinFragment()
        FragmentBtn.setOnClickListener {
            fragment?.let {
                var fragmentManager = supportFragmentManager.beginTransaction()
                when {
                    it.isAdded -> {
                        fragmentManager.remove(it)
                        fragmentLL.visibility = View.GONE
                    }
                    else -> {
                        fragmentManager.replace(R.id.fragmentLL, it)
                        fragmentLL.visibility = View.VISIBLE
                    }
                }
                fragmentManager.commit()
            }

        }
    }

    private fun initData(): List<User> {
        var list = mutableListOf<User>()
        for (i in 1..10) {
            list.add(User(name = "Name $i", sex = if (i % 2 == 0) 0 else 1, description = "User description $i "))
        }
        return list
    }
}
