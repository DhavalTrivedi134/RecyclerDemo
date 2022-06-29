package com.example.searchviewdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import com.example.searchviewdemo.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import java.util.*

class TextToSpeechActivity : AppCompatActivity(),TextToSpeech.OnInitListener {
    private var tts: TextToSpeech?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_to_speech)

        tts = TextToSpeech(this,this)
        val etEnteredText = findViewById<TextInputEditText>(R.id.et_entered_text)
        val btnSpeak = findViewById<MaterialButton>(R.id.btn_speak)

        btnSpeak.setOnClickListener {
            if(etEnteredText?.text!!.isEmpty()){
                Toast.makeText(this, "Please Enter Text to Speak", Toast.LENGTH_SHORT).show()
            }
            else{
                speakOut(etEnteredText.text.toString())
            }
        }

    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS){
            val result = tts!!.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_MISSING_DATA ||
                result == TextToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(this, "Language not Supported", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "initialization failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun speakOut(text: String){
        tts?.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }

    override fun onDestroy() {
        super.onDestroy()

        if(tts != null){
            tts?.stop()
            tts?.shutdown()
        }
    }
}