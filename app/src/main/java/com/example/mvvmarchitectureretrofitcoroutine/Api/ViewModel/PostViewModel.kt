package com.example.mvvmarchitectureretrofitcoroutine.Api.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmarchitectureretrofitcoroutine.Api.Model.posts
import com.example.mvvmarchitectureretrofitcoroutine.Api.Repository.PostRepository

class PostViewModel: ViewModel() {

    lateinit var postLiveData:LiveData<List<posts>>
    init {
       this.postLiveData=PostRepository.fetchposts()
    }

     fun canceljob(){
         PostRepository.canceljob()
     }

}