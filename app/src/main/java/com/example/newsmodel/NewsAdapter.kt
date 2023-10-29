package com.example.newsmodel

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.newsmodel.model.Article
import com.google.android.material.progressindicator.CircularProgressIndicator

class NewsAdapter(val context:Context,val articles:List<Article>):Adapter<NewsAdapter.ArticleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view =LayoutInflater.from(context).inflate(R.layout.item_view,parent,false,)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
    return articles.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        val article =articles[position]
        holder.newsTitle.text=article.title
        holder.newsDescription.text=article.description
        Glide.with(context)
            .load(article.urlToImage)
            .centerCrop()
            .placeholder(R.drawable.img_1)
            .into(holder.newsImage)
      holder.itemView.setOnClickListener {
          Toast.makeText(context,article.title,Toast.LENGTH_SHORT).show()
          val intent=Intent(context,DetailedActivity::class.java)
          intent.putExtra("URL",article.url)
          context.startActivity(intent)
      }
    }

    class ArticleViewHolder(itemView: View):ViewHolder(itemView){
        val newsTitle=itemView.findViewById<TextView>(R.id.newsTitle)
        val newsDescription=itemView.findViewById<TextView>(R.id.newsDescription)
        val newsImage=itemView.findViewById<ImageView>(R.id.newsImage)
    }
}