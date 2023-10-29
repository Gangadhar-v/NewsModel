package com.example.newsmodel

import com.example.newsmodel.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsService {

    @GET("${Constants.ENDPOINT}?apikey=${Constants.API_KEY}")
    fun getNewHeadLines(@Query("country") country:String):Call<News>
}