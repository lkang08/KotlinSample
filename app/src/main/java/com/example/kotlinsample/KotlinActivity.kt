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
            println("click")
        }

        //step 0
        mButton.setOnClickListener(View.OnClickListener { view: View ->
            view.visibility = View.GONE
            println("click")
        })

        //step lambda匿名函数
        mButton.setOnClickListener({ view: View ->
            view.visibility = View.GONE
            println("click")
        })

        //step 2 lambda表达式是函数调用的最后一个实参，就可以把它挪到小括号外面
        mButton.setOnClickListener() { view: View ->
            view.visibility = View.GONE
            println("click")
        }

        //step 3 当lambda是函数的唯一实参，就可以去掉空的小括号
        mButton.setOnClickListener { view: View ->
            view.visibility = View.GONE
            println("click")
        }

        //step 4 如果lambda的参数的类型可以被编译器推导出来，就可以省略它
        mButton.setOnClickListener { view ->
            view.visibility = View.GONE
            println("click")
        }

        //step 5 果这个lambda只有一个参数，并且这个参数的类型可以被推断出来
        mButton.setOnClickListener {
            it.visibility = View.GONE
            println("click")
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
