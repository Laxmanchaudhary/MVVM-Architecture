package com.example.mvvmarchitectureretrofitcoroutine.Api.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmarchitectureretrofitcoroutine.Api.AllApi.Api
import com.example.mvvmarchitectureretrofitcoroutine.Api.AllApi.ApiBuilder
import com.example.mvvmarchitectureretrofitcoroutine.Api.Model.posts
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import java.util.*

object PostRepository {
 var job:CompletableJob?=null

    fun fetchposts(): MutableLiveData<List<posts>> {
              job=Job()
        return object :MutableLiveData<List<posts>>(){
            override fun onActive() {
                super.onActive()
                job?.let {
                    CoroutineScope(IO).launch {
                        var data=ApiBuilder.getRemotedata(Api::class.java).getAllPost()
                        withContext(Main){
                            value=data

                        }
                        job?.complete()

                    }
                }

            }





        }
    }
    fun canceljob(){
        job?.cancel()
    }
}