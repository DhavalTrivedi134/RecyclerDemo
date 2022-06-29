package com.example.searchviewdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.searchviewdemo.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.checkbox.MaterialCheckBox

class CheckBoxActivity : AppCompatActivity() {
    private lateinit var submit:MaterialButton
    private lateinit var cricket:MaterialCheckBox
    private lateinit var chess:MaterialCheckBox
    private lateinit var carrom:MaterialCheckBox
    private lateinit var cards:MaterialCheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box)
        submit = findViewById(R.id.submit)
        cricket = findViewById(R.id.cricket)
        chess = findViewById(R.id.chess)
        carrom = findViewById(R.id.carrom)
        cards = findViewById(R.id.cards)

        submit.setOnClickListener {
            if(cricket.isChecked){
                Toast.makeText(this,"you selected"+" ${cricket.text}", Toast.LENGTH_LONG).show()
            }
            else if (chess.isChecked){
                Toast.makeText(this,"you selected"+" ${chess.text}", Toast.LENGTH_LONG).show()
            }
            else if (carrom.isChecked){
                Toast.makeText(this,"you selected"+" ${carrom.text}", Toast.LENGTH_LONG).show()
            }
            else if (cards.isChecked){
                Toast.makeText(this,"you selected"+" ${cards.text}", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"Please select", Toast.LENGTH_LONG).show()
            }

        }


    }
}