package com.example.mvvmarchitectureretrofitcoroutine.Api.AllApi

import com.example.mvvmarchitectureretrofitcoroutine.Api.Model.posts
import retrofit2.http.GET

interface Api {

    @GET("posts")
suspend fun getAllPost():List<posts>

}