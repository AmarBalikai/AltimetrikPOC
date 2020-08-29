package com.example.altimetrikpoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.altimetrikpoc.R
import com.example.altimetrikpoc.model.ModelResult
import kotlinx.android.synthetic.main.item_result.view.*


class ResultAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private var items = ArrayList<ModelResult>()
    lateinit var context: Context
    constructor(items: ArrayList<ModelResult>, context: Context?) {
        this.items = items
        if (context != null) {
            this.context = context
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return InterestViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_result, parent, false)
            )

    }

    // Binds each object in the ArrayList to a view
    override fun onBindViewHolder(@NonNull holder: RecyclerView.ViewHolder, position: Int) {

            holder.itemView.artistNameData.text = items[position]?.artistName
            holder.itemView.textView4.text = items[position]?.trackName
            holder.itemView.textView6.text = items[position]?.collectionName
            holder.itemView.textView8.text = items[position]?.collectionPrice
            Glide
                .with(context)
                .load(items[position].artworkUrl100)
                .into(holder.itemView.imageUrl)

    }

    class InterestViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}