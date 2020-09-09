package com.example.recycleviewapp

import TweetAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    private lateinit var tweetsRecyclerView: RecyclerView
    private lateinit var tweetAdapter : TweetAdapter
    var list: ArrayList<Any> =  ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tweetsRecyclerView = findViewById(R.id.tweets_recycler_view);
        tweetsRecyclerView.layoutManager = LinearLayoutManager(this)

        tweetAdapter = TweetAdapter()
        tweetsRecyclerView.adapter = tweetAdapter


        list.add("first Link")
        list.add("second Link")

        tweetAdapter.setItems(list)
    }
}