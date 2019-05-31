package com.example.kotlinsample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    var data: List<User>? = null
    override fun onCreateViewHolder(parent: ViewGroup, p: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, p: Int) {
        var user = data?.get(p) ?: return
        viewHolder.nameTv.text = user.name
        viewHolder.sexTv.text = if (user.sex == 0) "man" else "girl"
        viewHolder.descriptionTv.text = user.description
        viewHolder.iconIg.setImageResource(user.icon)

        data?.get(p)?.apply {
            with(viewHolder) {
                nameTv.text = name
                sexTv.text = if (sex == 0) "man" else "girl"
                descriptionTv.text = description
                iconIg.setImageResource(icon)
            }
        }
    }

    class MyViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
        var nameTv: TextView = rootView.myName
        var sexTv: TextView = rootView.mySex
        var descriptionTv: TextView = rootView.description
        var iconIg: ImageView = rootView.icon
    }
}