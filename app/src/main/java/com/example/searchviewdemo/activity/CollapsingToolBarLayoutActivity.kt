package com.example.searchviewdemo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.searchviewdemo.R

class CollapsingToolBarLayoutActivity : AppCompatActivity() {
    private lateinit var scrolling_demo:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_tool_bar_layout)
        scrolling_demo = findViewById(R.id.scrolling_demo)

        scrolling_demo.setOnClickListener {
            startActivity(Intent(this, ScrollingActivity::class.java))
        }
    }
}