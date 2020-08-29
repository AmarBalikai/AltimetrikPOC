package com.example.altimetrikpoc.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.altimetrikpoc.R
import com.example.altimetrikpoc.model.ModelResult

class ResultActivity : AppCompatActivity() {
    lateinit var results:ArrayList<ModelResult>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var bundle=intent.extras
        if(bundle!=null)
        {
            var results: ArrayList<ModelResult> = bundle.getParcelableArrayList("data")!!
        }
    }
}