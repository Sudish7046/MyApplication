package com.example.myapplication.view.adapters

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.data.Repository
import com.example.myapplication.model.ProductsItem
import com.example.myapplication.model.RankingsItem
import com.example.myapplication.utilities.ApplicationConstants
import kotlin.collections.HashMap

class RankingFragmentAdapter(var context: Context,var rankingProductItemModel:ArrayList<ProductsItem>):RecyclerView.Adapter<RankingFragmentAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        var view =LayoutInflater.from(context).inflate(R.layout.ranking_fragment_card_holder_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return rankingProductItemModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.rankItemTxt.text=rankingProductItemModel[position].name

    }


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        var rankItemTxt = itemView.findViewById<TextView>(R.id.ranking_holder_row_txt)
    }
}