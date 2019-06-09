package com.example.myapplication.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.util.Log
import com.example.myapplication.data.Repository
import com.example.myapplication.model.MainResponse
import com.example.myapplication.view.activities.DashboardActivity

class DashboardFragmentViewModel : ViewModel(){

    fun fetchResponse(context: Context):LiveData<MainResponse>
    {
        return Repository.getRepoInstance().fetchInsertResponse(context)
    }

    fun fetchDBResponse(context:Context):LiveData<MainResponse>
    {

        return Repository.getRepoInstance().readDataFromDb(context)

    }
}