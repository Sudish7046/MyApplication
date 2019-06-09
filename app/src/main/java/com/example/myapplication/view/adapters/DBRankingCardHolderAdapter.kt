package com.example.myapplication.view.adapters

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.model.RankingsItem
import com.example.myapplication.view.activities.DashboardActivity
import com.example.myapplication.view.fragment.CategoriesFragment
import com.example.myapplication.view.fragment.RankingFragment


class DBRankingCardHolderAdapter(var context: Context, var cardItemList:ArrayList<RankingsItem>):RecyclerView.Adapter<DBRankingCardHolderAdapter.ViewHolder>() {
    private var rankingFragmentInstance:RankingFragment?=null
    private var bundle:Bundle?=null
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.dashboard_fragment_ranking_card_holder_row,parent,false)
        rankingFragmentInstance= RankingFragment()

        bundle=Bundle()
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cardItemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.cardItemTxt.text=cardItemList[position].ranking
        holder.cardLayout.setOnClickListener {
            bundle?.putSerializable("rankingItem",cardItemList[position])
            bundle?.putInt("position",position)

            rankingFragmentInstance?.arguments=bundle
            (context as DashboardActivity).supportFragmentManager.beginTransaction().replace(R.id.ll_dashboard_activity,rankingFragmentInstance!!).addToBackStack(null).commit()
        }
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        var cardItemTxt=itemView.findViewById<TextView>(R.id.card_holder_row_txt)
        var cardLayout=itemView.findViewById<LinearLayout>(R.id.ll_card_item_holder)
    }
}