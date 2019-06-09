package com.example.myapplication.view.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.model.VariantsItem

class ColorDescAdapter(var context: Context, var descList:ArrayList<VariantsItem>): RecyclerView.Adapter<ColorDescAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        var view= LayoutInflater.from(context).inflate(R.layout.desc_item_holder,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return descList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.descTxt.text=descList[position]?.color
    }

    class ViewHolder(itenView: View): RecyclerView.ViewHolder(itenView)
    {
        var descTxt=itemView.findViewById<TextView>(R.id.desc_txt)
    }
}