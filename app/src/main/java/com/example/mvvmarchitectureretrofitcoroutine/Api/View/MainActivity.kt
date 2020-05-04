package com.example.mvvmarchitectureretrofitcoroutine.Api.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmarchitectureretrofitcoroutine.Api.Adapter.PostAdapter
import com.example.mvvmarchitectureretrofitcoroutine.Api.ViewModel.PostViewModel
import com.example.mvvmarchitectureretrofitcoroutine.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var post:PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PostsrecyclerView.layoutManager=LinearLayoutManager(this)
        PostsrecyclerView.setHasFixedSize(true)
        getposts()


    }


    fun getposts(){
        post=ViewModelProvider.AndroidViewModelFactory(application).create(PostViewModel::class.java)
        post.postLiveData.observe(this, Observer {
            var postadpter=PostAdapter(this,it)
            PostsrecyclerView.adapter=postadpter
        })


    }

    override fun onDestroy() {
        super.onDestroy()
        post.canceljob()

    }
}
