package com.example.myapplication.view.adapters

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.model.CategoriesItem
import com.example.myapplication.model.RankingsItem
import com.example.myapplication.utilities.ApplicationConstants

class DashboardFragmentAdapter(var context: Context,var mainAdapterList:ArrayList<Any>?):RecyclerView.Adapter<DashboardFragmentAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.dashboard_fragment_view_holder,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return mainAdapterList!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

       when(position)
        {
            ApplicationConstants.TYPE_POPULAR->
            {
                holder.cardTitleTxt.text=context.resources.getString(R.string.popular_txt)
                var dashboardCardHolderAdapter=DBRankingCardHolderAdapter(context,
                    mainAdapterList?.get(position) as ArrayList<RankingsItem>
                )
                holder.cardRecycler.layoutManager=LinearLayoutManager(context)
                holder.cardRecycler.adapter=dashboardCardHolderAdapter
           }
            ApplicationConstants.TYPE_CATEGORIES->
            {
                holder.cardTitleTxt.text=context.resources.getString(R.string.category_txt)
                var dashboardCardHolderAdapter=DBCategoryCardHolderAdapter(context, mainAdapterList?.get(position) as ArrayList<CategoriesItem>)
                holder.cardRecycler.layoutManager=LinearLayoutManager(context)
                holder.cardRecycler.adapter=dashboardCardHolderAdapter
            }
            }

        }


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        var cardTitleTxt=itemView.findViewById<TextView>(R.id.dashboard_holder_title)
        var cardRecycler=itemView.findViewById<RecyclerView>(R.id.dashboard_holder_recycler)
    }
}