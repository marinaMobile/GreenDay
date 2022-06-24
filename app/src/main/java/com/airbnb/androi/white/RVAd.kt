package com.airbnb.androi.white

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.androi.R

class RVAd (private val data:List<DataClass>) : RecyclerView.Adapter<RVAd.CustomViewHolder>() {

    class CustomViewHolder(parent: View): RecyclerView.ViewHolder(parent) {
        val img: ImageView = parent.findViewById(R.id.custom_img)
        val txt: TextView = parent.findViewById(R.id.custom_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.img.setImageResource(data[position].img)
        holder.txt.text = data[position].txt
    }

    override fun getItemCount(): Int = data.count()
}