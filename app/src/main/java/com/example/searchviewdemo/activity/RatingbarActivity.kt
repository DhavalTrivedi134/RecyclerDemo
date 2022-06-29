package com.example.searchviewdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import com.example.searchviewdemo.R

class RatingbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratingbar)
        supportActionBar?.title = "Rating Bar"

        val ratingBar = findViewById<RatingBar>(R.id.ratingbar)
        val submit = findViewById<Button>(R.id.submit)

        submit.setOnClickListener {
            var rating:String = "Rating: " +ratingBar.rating
            var stars: String = "Rating Stars: " +ratingBar.numStars
            Toast.makeText(this,rating+"\n"+stars, Toast.LENGTH_LONG).show()
        }

    }
}