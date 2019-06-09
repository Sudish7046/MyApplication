package com.example.myapplication.view.fragment

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.data.Repository
import com.example.myapplication.databinding.RankingFragmentBinding
import com.example.myapplication.model.ProductsItem
import com.example.myapplication.model.RankingsItem
import com.example.myapplication.utilities.ApplicationConstants
import com.example.myapplication.view.adapters.RankingFragmentAdapter

class RankingFragment:Fragment() {
    var databinding: RankingFragmentBinding? = null
    var rankingItemModel: RankingsItem? = null
    var productItemList:ArrayList<ProductsItem>?=null
    var prodItem:ProductsItem?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        databinding = DataBindingUtil.inflate(inflater, R.layout.ranking_fragment, container, false)
        rankingItemModel = arguments?.getSerializable("rankingItem") as RankingsItem
        productItemList=ArrayList()

        when (rankingItemModel!!.ranking.toLowerCase().replace("\\s+".toRegex(), "")) {


            ApplicationConstants.TYPE_MOST_VIEWED -> {
                Repository.getRepoInstance().readDataFromDb(requireContext())
                    .observe(context as LifecycleOwner, Observer {

                        it?.categories?.forEach {
                            it?.products?.forEach {
                                prodItem=it
                                rankingItemModel!!.products.forEach {

                                    if(prodItem!!.id.toString()==Math.round((it as Map<String,Double>).get("id")!!).toString())
                                    {
                                        productItemList!!.add(prodItem!!)

                                    }
                                }
                            }
                        }

                        databinding?.rankingHolderRecycler?.adapter?.notifyDataSetChanged()
                    })
            }




            ApplicationConstants.TYPE_MOST_ORDERED->
            {
                Repository.getRepoInstance().readDataFromDb(requireContext())
                    .observe(context as LifecycleOwner, Observer {

                        it?.categories?.forEach {
                            it?.products?.forEach {
                                prodItem=it
                                rankingItemModel!!.products.forEach {

                                    if(prodItem!!.id.toString()==Math.round((it as Map<String,Double>).get("id")!!).toString())
                                    {
                                        productItemList!!.add(prodItem!!)

                                    }
                                }
                            }
                        }

                        databinding?.rankingHolderRecycler?.adapter?.notifyDataSetChanged()
                    })
            }
            ApplicationConstants.TYPE_MOST_SHARED->
            {
                Repository.getRepoInstance().readDataFromDb(requireContext())
                    .observe(context as LifecycleOwner, Observer {

                        it?.categories?.forEach {
                            it?.products?.forEach {
                                prodItem=it
                                rankingItemModel!!.products.forEach {

                                    if(prodItem!!.id.toString()==Math.round((it as Map<String,Double>).get("id")!!).toString())
                                    {
                                        productItemList!!.add(prodItem!!)

                                    }
                                }
                            }
                        }

                        databinding?.rankingHolderRecycler?.adapter?.notifyDataSetChanged()
                    })
            }



        }

        return databinding?.root

    }



    override fun onResume() {
        super.onResume()
        rankingItemModel?.let {
            var rankingFragmentAdapter = RankingFragmentAdapter(
                requireContext(),
                productItemList!!
            )
            databinding?.rankingHolderRecycler?.layoutManager = LinearLayoutManager(requireContext())
            databinding?.rankingHolderRecycler?.adapter = rankingFragmentAdapter
        }


    }
}