package com.example.searchviewdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.searchviewdemo.model.ItemsViewModel
import com.example.searchviewdemo.R
import com.example.searchviewdemo.utils.onItemClickListener
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class customAdapter(private var list: List<ItemsViewModel>): RecyclerView.Adapter<customAdapter.MyHolder>() {
    private lateinit var mlistener: onItemClickListener

    fun onItemClickListener(listener: onItemClickListener){
        mlistener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_data_design,parent,false)
        return MyHolder(view,mlistener)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val ItemsViewModel = list[position]
        holder.imageView.setImageResource(ItemsViewModel.image)
        holder.textView.text = ItemsViewModel.name
        holder.textview2.text = ItemsViewModel.activityName
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyHolder(itemView: View,listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
            val textView:MaterialTextView = itemView.findViewById(R.id.textview)
            val imageView:ShapeableImageView = itemView.findViewById(R.id.imageview)
            val textview2:MaterialTextView = itemView.findViewById(R.id.textview2)

        init {
            /*itemView.setOnClickListener(object :View.OnClickListener{
                override fun onClick(v: View?) {
                    TODO("Not yet implemented")
                }
            })*/
            itemView.setOnClickListener {
                listener.onItemClick(layoutPosition)
            }
        }
    }

}