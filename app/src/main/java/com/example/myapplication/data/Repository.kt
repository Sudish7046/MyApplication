package com.example.myapplication.data

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.content.Context
import android.util.Log
import com.example.myapplication.data.response.ResponseModel
import com.example.myapplication.model.MainResponse
import com.example.myapplication.network.NetworkClient
import com.example.myapplication.network.NetworkInterface
import com.example.myapplication.utilities.ApplicationConstants
import retrofit2.Call
import retrofit2.Callback

object Repository {
var instance:Repository?=null

    var responseModelValue:MutableLiveData<MainResponse>?=null

        fun getRepoInstance():Repository
        {
            if (instance==null)
                instance=Repository

            return instance!!
        }


    fun readDataFromDb(context: Context):LiveData<MainResponse>
    {
       responseModelValue=MutableLiveData<MainResponse>()

        AppDatabase.getInstance(context).responseDao().getFromDB().observe(context as LifecycleOwner,
            Observer {
                if(it?.mainResponse!=null)
                {
                    Log.e("DB Response",it?.mainResponse.toString())
                    responseModelValue?.value=it?.mainResponse!!
                }
                else
                {
                    responseModelValue?.value=null
                }
            })
        return responseModelValue!!
    }

    fun fetchInsertResponse(context: Context) :LiveData<MainResponse>
    {
       responseModelValue=MutableLiveData<MainResponse>()

            var networkInterface= NetworkClient.getNetworkClientInstance()?.create(NetworkInterface::class.java)
            var callResponseModel=networkInterface?.fetchData()
            callResponseModel?.enqueue(object: Callback<MainResponse>
            {
                override fun onFailure(call: Call<MainResponse>?, t: Throwable?) {

                    Log.e("MainResponse",t?.message.toString())
                    responseModelValue?.value=null

                }

                override fun onResponse(call: Call<MainResponse>?, mainResponse: retrofit2.Response<MainResponse>?) {

                    Log.e("MainResponse",mainResponse?.body()?.toString())
                    mainResponse?.body()?.let {

                        var responseModel=ResponseModel(ApplicationConstants.PRIMARY_KEY_RESPONSE,it)
                        Thread(Runnable {
                            AppDatabase.getInstance(context).responseDao().insertInDB(responseModel)

                        }).start()

                        responseModelValue?.value=it

                    }

                }

            })



        return responseModelValue!!

    }
}