package com.example.searchviewdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import com.example.searchviewdemo.R

class SeekBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar)
        supportActionBar?.title = "SeekBar"

        var seekbar_default = findViewById<SeekBar>(R.id.seekbar_default)
        var seekbar_descrete = findViewById<SeekBar>(R.id.seekbar_descrete)

        seekbar_default?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Toast.makeText(this@SeekBarActivity,"Seekbar progress: $progress", Toast.LENGTH_LONG).show()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(this@SeekBarActivity,"Seekbar started", Toast.LENGTH_LONG).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(this@SeekBarActivity,"Seekbar finished", Toast.LENGTH_LONG).show()
            }

        })

        seekbar_descrete.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Toast.makeText(this@SeekBarActivity,"Seekbar progress: $progress", Toast.LENGTH_LONG).show()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(this@SeekBarActivity,"Seekbar started", Toast.LENGTH_LONG).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(this@SeekBarActivity,"Seekbar finished", Toast.LENGTH_LONG).show()
            }

        })
    }
}