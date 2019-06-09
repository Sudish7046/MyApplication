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
import com.example.myapplication.model.CategoriesItem
import com.example.myapplication.utilities.ApplicationConstants
import com.example.myapplication.view.activities.DashboardActivity
import com.example.myapplication.view.fragment.CategoriesFragment
import com.example.myapplication.view.fragment.RankingFragment

class DBCategoryCardHolderAdapter(var context: Context,var categoryList:ArrayList<CategoriesItem>): RecyclerView.Adapter<DBCategoryCardHolderAdapter.ViewHolder>(){
    private var categoryFragmentInstance: CategoriesFragment?=null
    private var bundle: Bundle?=null
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): DBCategoryCardHolderAdapter.ViewHolder {
        var view= LayoutInflater.from(context).inflate(R.layout.dashboard_fragment_category_card_holder_row,parent,false)
        categoryFragmentInstance= CategoriesFragment()
        bundle=Bundle()
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {

        holder.cardTxt.text=categoryList[position].name
        holder.cardLayout.setOnClickListener {
            bundle?.putSerializable(ApplicationConstants.TYPE_CATEGORY_ITEM,categoryList[position])
            categoryFragmentInstance?.arguments=bundle
            (context as DashboardActivity).supportFragmentManager.beginTransaction().replace(R.id.ll_dashboard_activity,categoryFragmentInstance!!).addToBackStack(null).commit()
        }
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
      var cardTxt=itemView.findViewById<TextView>(R.id.card_holder_row_txt)
        var cardLayout=itemView.findViewById<LinearLayout>(R.id.ll_card_item_holder)

    }

}