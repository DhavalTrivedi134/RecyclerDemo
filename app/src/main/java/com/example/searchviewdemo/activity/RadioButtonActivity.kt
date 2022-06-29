package com.example.searchviewdemo.activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.searchviewdemo.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.radiobutton.MaterialRadioButton

class RadioButtonActivity : AppCompatActivity() {
    private lateinit var radiogroup:RadioGroup
    private lateinit var male:MaterialRadioButton
    private lateinit var female:MaterialRadioButton
    private lateinit var transgender:MaterialRadioButton
    private lateinit var show:MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)
        supportActionBar?.title = "Radio Button Demo"

        radiogroup = findViewById(R.id.radiogroup)
        male = findViewById(R.id.male)
        female = findViewById(R.id.female)
        transgender = findViewById(R.id.transgender)
        show = findViewById(R.id.show)

        radiogroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton: RadioButton = findViewById(checkedId)
            Toast.makeText(this," Gender :"+" ${radioButton.text}", Toast.LENGTH_SHORT).show()
        }

        show.setOnClickListener {
            var id:Int = radiogroup.checkedRadioButtonId
            try {
                val radioButton: RadioButton = findViewById(id)
                if (id != -1) {
                    Toast.makeText(this, "show gender: ${radioButton.text}", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(this, "select gender", Toast.LENGTH_SHORT).show()
                }

            }catch (exception:Exception){
                println(exception)
            }

        }

    }
}