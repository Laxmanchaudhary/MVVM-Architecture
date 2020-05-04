package com.example.mvvmarchitectureretrofitcoroutine.Api.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmarchitectureretrofitcoroutine.Api.Model.posts
import com.example.mvvmarchitectureretrofitcoroutine.R
import kotlinx.android.synthetic.main.post_row.view.*

class PostAdapter(var context:Context, var postist:List<posts>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var id=itemView.findViewById<TextView>(R.id.id)
//        var title=itemView.findViewById<TextView>(R.id.title)
//        var body=itemView.findViewById<TextView>(R.id.body)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.post_row,parent,false)
       return ViewHolder(view)
    }

    override fun getItemCount()=postist.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.title.text=postist[position].title
        holder.itemView.body.text=postist[position].body
        holder.itemView.postid.text=postist[position].id.toString()

    }
}