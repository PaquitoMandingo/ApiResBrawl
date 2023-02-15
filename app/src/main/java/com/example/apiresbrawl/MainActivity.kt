package com.example.apiresbrawl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.brawlstars.R
import com.example.brawlstars.adapter.BrawlerAdapter
import com.example.brawlstars.api.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: BrawlerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        CoroutineScope(Dispatchers.IO).launch {
            val token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6Ijc5ZmE5ZGIyLTRmNjItNGEzMi1iZDRiLWNlZWRjOTBlZGZlZiIsImlhdCI6MTY3NjI5NDQ0Niwic3ViIjoiZGV2ZWxvcGVyL2FhNzk1NGFjLTBkZjEtMTZmNy1mMDBiLWEyYWY0ODlkMDI1MSIsInNjb3BlcyI6WyJicmF3bHN0YXJzIl0sImxpbWl0cyI6W3sidGllciI6ImRldmVsb3Blci9zaWx2ZXIiLCJ0eXBlIjoidGhyb3R0bGluZyJ9LHsiY2lkcnMiOlsiMi4xMzkuMTU4LjIxNyJdLCJ0eXBlIjoiY2xpZW50In1dfQ.3Ikrboty1jHDkJsw-gsutCN2VUwjMrWrnBoE3htxgd-KMVRXZDy18upKNHn5z76t6Bc0zzpEL95j5EiZGQrdEg"
            val brawlers = ApiClient.create(token).getBrawlers(token)
            runOnUiThread {
                adapter = BrawlerAdapter(brawlers)
                recyclerView.adapter = adapter
            }
        }
    }
}
