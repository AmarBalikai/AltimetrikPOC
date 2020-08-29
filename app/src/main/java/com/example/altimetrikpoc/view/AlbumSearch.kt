package com.example.altimetrikpoc.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.altimetrikpoc.R
import com.example.altimetrikpoc.model.ModelResult
import com.example.altimetrikpoc.viewModel.ViewModelAlbumSearch
import kotlinx.android.synthetic.main.activity_album_search.*
import java.io.Serializable
import java.util.*
import java.util.stream.Collectors

class AlbumSearch : AppCompatActivity() {
    lateinit var mViewModelAlbumSearch:ViewModelAlbumSearch;
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_search)
        mViewModelAlbumSearch=ViewModelProvider(this).get(ViewModelAlbumSearch::class.java)

            mViewModelAlbumSearch.liveDataModelData.observe(this, Observer {
                Toast.makeText(this,"HI"+it.size,Toast.LENGTH_SHORT).show()
                var intent=Intent(this,ResultActivity::class.java)
                intent.putParcelableArrayListExtra("dota",it)
                startActivity(intent)
               /* for ( data in it)
                {
                    System.out.println(data.artistName+"           :           "+data.trackName)
                }*/
            })
        btnSearch.setOnClickListener {

            val dataSearchResult: List<ModelResult>? = mViewModelAlbumSearch.liveDataModelData.value
                ?.stream()
                ?.filter { c -> c.artistName.toLowerCase(Locale.ENGLISH) == etArtistName.text.toString().toLowerCase(Locale.ENGLISH) && c.trackName.toLowerCase(Locale.ENGLISH) == etTrackName.text.toString().toLowerCase(Locale.ENGLISH)  }
                ?.collect(Collectors.toList())

            Toast.makeText(this,""+dataSearchResult?.size,Toast.LENGTH_SHORT).show()
        }
    }
}