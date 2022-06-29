package com.example.searchviewdemo.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.searchviewdemo.R
import com.example.searchviewdemo.adapter.RecyclerDemoAdapter
import com.example.searchviewdemo.model.Fruits
import com.google.android.material.button.MaterialButton

class RecyclerDemoActivity : AppCompatActivity() {
        private var arrayList = ArrayList<Fruits>()
        @SuppressLint("ResourceAsColor")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_recycler_demo)

            arrayList.add(Fruits("Apple my Heart",R.drawable.winner))
            arrayList.add(Fruits("Banana",R.drawable.winner))
            arrayList.add(Fruits("Chickoo",R.drawable.winner))
            arrayList.add(Fruits("Dragon Fruit The kamalam",R.drawable.winner))
            arrayList.add(Fruits("Grapes",R.drawable.winner))
            arrayList.add(Fruits("Kiwi",R.drawable.winner))
            arrayList.add(Fruits("Juicy Lemon",R.drawable.winner))
            arrayList.add(Fruits("Mango The King of Fruits",R.drawable.winner))
            arrayList.add(Fruits("orange",R.drawable.winner))
            arrayList.add(Fruits("Papaya",R.drawable.winner))
            arrayList.add(Fruits("Apple my Heart",R.drawable.winner))
            arrayList.add(Fruits("Banana",R.drawable.winner))
            arrayList.add(Fruits("Chickoo",R.drawable.winner))
            arrayList.add(Fruits("Dragon Fruit The kamalam",R.drawable.winner))
            arrayList.add(Fruits("Grapes",R.drawable.winner))
            arrayList.add(Fruits("Kiwi",R.drawable.winner))
            arrayList.add(Fruits("Juicy Lemon",R.drawable.winner))
            arrayList.add(Fruits("Mango The King of Fruits",R.drawable.winner))
            arrayList.add(Fruits("orange",R.drawable.winner))
            arrayList.add(Fruits("Papaya",R.drawable.winner))

            val rv = findViewById<RecyclerView>(R.id.rv)
            val linear_rv = findViewById<MaterialButton>(R.id.linear_rv)
            val grid_rv = findViewById<MaterialButton>(R.id.grid_rv)
            val staggred_grid = findViewById<MaterialButton>(R.id.staggered_grid)
            val spannable_grid = findViewById<MaterialButton>(R.id.spannable_grid)

            val customAdapter = RecyclerDemoAdapter(arrayList)
            rv.adapter = customAdapter
            rv.layoutManager = LinearLayoutManager(this)

            linear_rv.setOnClickListener {
                rv.layoutManager = LinearLayoutManager(this)
            }

            grid_rv.setOnClickListener {
                rv.layoutManager = GridLayoutManager(this,2)
            }

            staggred_grid.setOnClickListener {
                rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            }

            spannable_grid.setOnClickListener {
                val layoutManager = GridLayoutManager(this,6)
                layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return when (position % 5) {
                            0,1 -> 3
                            2,3,4 -> 2
                            else -> 1
                        }

                    }
                }

                rv.layoutManager = layoutManager
            }
        }
}