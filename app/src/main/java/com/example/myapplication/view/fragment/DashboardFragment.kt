package com.example.myapplication.view.fragment

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.DashboardFragmentBinding
import com.example.myapplication.view.adapters.DashboardFragmentAdapter
import com.example.myapplication.viewModel.DashboardFragmentViewModel

class DashboardFragment:Fragment() {

    var databinding: DashboardFragmentBinding?=null
    var mainResponseList=ArrayList<Any>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var viewModel= ViewModelProviders.of(this).get(DashboardFragmentViewModel::class.java)
        databinding=DataBindingUtil.inflate(inflater, R.layout.dashboard_fragment,container,false)
       databinding?.dashboardFragmentViewModel=viewModel
        setData()
        callApiStatus()
        return databinding?.root
    }


    private fun callApiStatus()
    {
        databinding?.dashboardFragmentViewModel?.fetchDBResponse(requireContext())?.observe(this, Observer {

            if(it==null)
            {
                Thread(Runnable {

                    databinding?.dashboardFragmentViewModel?.fetchResponse(requireContext())?.observe(this, Observer {

                        mainResponseList!!.clear()
                        if(it?.rankings!=null)
                            mainResponseList!!.addAll(listOf(it.rankings))
                        if(it?.categories!=null)
                            mainResponseList!!.addAll(listOf(it.categories))

                        databinding?.dashboardFragmentRecycler?.adapter?.notifyDataSetChanged()
                    })
                }).start()

            }
            else
            {
                mainResponseList!!.clear()
                if(it?.rankings!=null)
                    mainResponseList!!.addAll(listOf(it.rankings))
                if(it?.categories!=null)
                    mainResponseList!!.addAll(listOf(it.categories))

                databinding?.dashboardFragmentRecycler?.adapter?.notifyDataSetChanged()
            }

        })
    }

    private fun setData()
    {
        var dashboardFragmentAdapter=DashboardFragmentAdapter(requireContext(), mainResponseList)
        databinding?.dashboardFragmentRecycler?.layoutManager=LinearLayoutManager(requireContext())
        databinding?.dashboardFragmentRecycler?.adapter=dashboardFragmentAdapter
    }
}