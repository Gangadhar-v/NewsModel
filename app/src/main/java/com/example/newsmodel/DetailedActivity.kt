package com.example.newsmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val url =intent.getStringExtra("URL")
        if(url!=null){
            val detailedActivity =findViewById<WebView>(R.id.detailedWebView)
            detailedActivity.settings.javaScriptEnabled = true
            detailedActivity.settings.userAgentString = "Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3"
            detailedActivity.webViewClient =object:WebViewClient (){
                override fun onPageFinished(view: WebView?, url: String?) {
                     super.onPageFinished(view, url)
                    val progressBar=findViewById<ProgressBar>(R.id.progressBar)
                    progressBar.visibility = View.GONE
                    detailedActivity.visibility =View.VISIBLE
                }
            }
            detailedActivity.loadUrl(url)
        }
    }
}