package com.example.searchviewdemo

import com.example.searchviewdemo.model.GetDataItem
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("posts")
    fun retrieveData(): Call<List<GetDataItem>>
}