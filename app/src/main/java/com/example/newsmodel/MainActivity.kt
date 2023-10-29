package com.example.newsmodel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.newsmodel.databinding.ActivityMainBinding
import com.example.newsmodel.model.Article
import com.example.newsmodel.model.News
import com.example.newsmodel.model.NewsInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(binding.root)

        getNews()
    }

    private fun getNews() {
        val news =NewsInstance.newsService.getNewHeadLines("in")
        news.enqueue(object:Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {

                val responseBody=response.body()
                if(responseBody!=null){
                    val articles=responseBody.articles
                    val adapter = NewsAdapter(this@MainActivity,articles)
                    Log.d("GANG","${responseBody.articles}")
                  binding.corouselrecyclerView.adapter=adapter
                    binding.corouselrecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
            override fun onFailure(call: Call<News>, t: Throwable) {
                  Log.d("GANG","${t.message}")
            }

        })
    }

}
// https://newsapi.org/v2/top-headlines?country=in&apiKey=ddc9292c6f8242889e972a21f63914c4