package com.example.myapplication.view.adapters

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.model.CategoriesItem
import com.example.myapplication.model.VariantsItem



class CategoryFragmentAdapter(var context: Context,var categoryItem:CategoriesItem): RecyclerView.Adapter<CategoryFragmentAdapter.ViewHolder>() {
    var sizeDescAdapter:SizeDescAdapter?=null
    var colorDescAdapter:ColorDescAdapter?=null
    var priceDescAdapter:PriceDescAdapter?=null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.category_fragment_card_holder_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return categoryItem?.products?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemText.text= categoryItem?.products?.get(position)?.name
        holder.moreTxt.setOnClickListener {
            if(holder.descLayout.visibility==View.GONE)
            {
                sizeDescAdapter= SizeDescAdapter(context, categoryItem?.products?.get(position)?.variants as ArrayList<VariantsItem>)
                colorDescAdapter= ColorDescAdapter(context,categoryItem?.products?.get(position)?.variants as ArrayList<VariantsItem>)
                priceDescAdapter=PriceDescAdapter(context,categoryItem?.products?.get(position)?.variants as ArrayList<VariantsItem>)
                holder.descLayout.visibility=View.VISIBLE
                holder.moreTxt.text=context.resources.getString(R.string.less_txt)
                holder.sizeDescLayout.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                holder.colorDescLayout.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                holder.amtDescLayout.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                holder.sizeDescLayout.adapter=sizeDescAdapter
                holder.colorDescLayout.adapter=colorDescAdapter
                holder.amtDescLayout.adapter=priceDescAdapter

            }
            else
            {
                holder.descLayout.visibility=View.GONE
                holder.moreTxt.text=context.resources.getString(R.string.more_txt)

            }
        }
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
         var itemText=itemView.findViewById<TextView>(R.id.ranking_holder_row_txt)
         var moreTxt=itemView.findViewById<TextView>(R.id.ranking_holder_row_more_txt)
        var descLayout=itemView.findViewById<LinearLayout>(R.id.ll_desc)

        var sizeDescLayout=itemView.findViewById<RecyclerView>(R.id.size_txt)
        var colorDescLayout=itemView.findViewById<RecyclerView>(R.id.color_txt)
        var amtDescLayout=itemView.findViewById<RecyclerView>(R.id.amt_txt)

    }
}