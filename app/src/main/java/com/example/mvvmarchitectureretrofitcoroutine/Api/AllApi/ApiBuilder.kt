package com.example.mvvmarchitectureretrofitcoroutine.Api.AllApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiBuilder {

    var base_url="https://jsonplaceholder.typicode.com/"

    var builder=Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create())

    fun <T>getRemotedata( myclass: Class<T>): T{
        return builder.build().create(myclass)

    }
}