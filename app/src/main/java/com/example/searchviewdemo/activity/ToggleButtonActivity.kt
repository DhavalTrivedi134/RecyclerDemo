package com.example.searchviewdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.searchviewdemo.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup

class ToggleButtonActivity : AppCompatActivity() {
    private lateinit var submit:MaterialButton
    private lateinit var toggleButton : MaterialButtonToggleGroup
    private lateinit var button1:MaterialButton
    private lateinit var button2:MaterialButton
    private lateinit var button3:MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toggle_button)
        supportActionBar?.title = "Toggle Button"
        submit = findViewById(R.id.submit)
        toggleButton = findViewById(R.id.toggleButton)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)

        submit.setOnClickListener {
            val stringBuilder = StringBuilder()
            val toggle:Int = toggleButton.checkedButtonId
            if (toggle != -1){
                stringBuilder.append("Toggle -1").append(button1.text)
                stringBuilder.append(" Toggle -2").append(button2.text)
                stringBuilder.append(" Toggle -3").append(button3.text)
                Toast.makeText(applicationContext,stringBuilder, Toast.LENGTH_LONG).show()
            }

            else{
                Toast.makeText(applicationContext,"select toggle", Toast.LENGTH_LONG).show()
            }
        }
    }
}