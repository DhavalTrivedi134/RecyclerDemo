package com.example.searchviewdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.searchviewdemo.ApiInterface
import com.example.searchviewdemo.R
import com.example.searchviewdemo.model.GetDataItem
import com.google.android.material.textview.MaterialTextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitDemoActivity : AppCompatActivity() {
    private val baseUrl = "https://jsonplaceholder.typicode.com/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_demo)

        retrieveData()
    }

    private fun retrieveData() {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofit.retrieveData()

        retrofitData.enqueue(object : Callback<List<GetDataItem>?> {
            override fun onResponse(
                call: Call<List<GetDataItem>?>,
                response: Response<List<GetDataItem>?>
            ) {
                val responseBody = response.body()!!
                val stringBuilder = StringBuilder()

                for (GetDataItem in responseBody){
                    stringBuilder.append(GetDataItem.title)
                    stringBuilder.append("\n")
                }

                val txtR = findViewById<MaterialTextView>(R.id.txtR)
                txtR.text = stringBuilder
            }

            override fun onFailure(call: Call<List<GetDataItem>?>, t: Throwable) {
                Toast.makeText(this@RetrofitDemoActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}