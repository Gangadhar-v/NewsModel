package com.example.newsmodel.model

import com.example.newsmodel.Constants
import com.example.newsmodel.NewsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object NewsInstance {

    val newsService: NewsService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsService =retrofit.create(NewsService::class.java)
    }

}