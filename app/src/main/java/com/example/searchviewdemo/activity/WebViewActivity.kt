package com.example.searchviewdemo.activity

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.searchviewdemo.R

class WebViewActivity : AppCompatActivity() {
    private lateinit var web_demo: WebView
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        web_demo = findViewById(R.id.web_demo)
        webviewshow()
    }


    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webviewshow() {
        web_demo.webViewClient = WebViewClient()

        web_demo.apply {
            loadUrl("https://www.google.com/")
            settings.javaScriptEnabled =true
            settings.safeBrowsingEnabled = true
        }
    }

    override fun onBackPressed() {
        if (web_demo.canGoBack()){
            web_demo.goBack()
        }
        else {
            super.onBackPressed()
        }
    }
}