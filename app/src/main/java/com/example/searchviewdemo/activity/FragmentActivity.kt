package com.example.searchviewdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.searchviewdemo.fragment.login_fragment
import com.example.searchviewdemo.R

class FragmentActivity : AppCompatActivity() {
    private lateinit var loginbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        loginbutton = findViewById(R.id.press_here_to_login)


        loginbutton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                val mfragmentmanagar = supportFragmentManager
                val fragment: login_fragment = login_fragment()
                val mfragmenttransaction = mfragmentmanagar.beginTransaction()
                mfragmenttransaction.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_right,
                    R.anim.enter_from_right,
                    R.anim.exit_to_right
                )
                mfragmenttransaction.addToBackStack(null)
                mfragmenttransaction.replace(R.id.frameLayout,fragment,"login_fragment").commit()
                loginbutton.visibility = View.GONE

            }

        })


    }
}