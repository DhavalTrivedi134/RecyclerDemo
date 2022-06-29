package com.example.searchviewdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.searchviewdemo.R
import com.example.searchviewdemo.model.Fruits
import com.google.android.material.textview.MaterialTextView

class RecyclerDemoAdapter(var arrayList:ArrayList<Fruits>): RecyclerView.Adapter<RecyclerDemoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_rv,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txt.text = arrayList[position].name
        holder.image.setImageResource(arrayList[position].image)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var txt = itemView.findViewById<MaterialTextView>(R.id.txt)
        val image = itemView.findViewById<ImageView>(R.id.img)


    }
}