package com.example.searchviewdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.searchviewdemo.R
import java.util.regex.Pattern

class login_fragment: Fragment() {

    private lateinit var email:EditText
    private lateinit var password:EditText
    private lateinit var login:Button
    var emailPattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
    : View? {
        val view: View = inflater.inflate(R.layout.login_fragment,container,false)

        email = view.findViewById(R.id.fragment_email)
        password = view.findViewById(R.id.fragment_password)
        login = view.findViewById(R.id.fragment_login)

        //val mfragment = showdata_fragment()

        login.setOnClickListener {

            if (email.text.toString().equals("")){
                email.error = "Enter Email Address"
            }
            else if (!isValidString(email.text.toString())) {
                email.error = "Please Enter Valid Email Address"
            }
            else if(password.text.toString().equals("")){
                password.error = "Enter Password"
            }
            else {
                Toast.makeText(requireContext(), "Login Successfully", Toast.LENGTH_SHORT).show()
                val mfragmentmanagar = activity?.supportFragmentManager
                val mfragmenttransaction = mfragmentmanagar?.beginTransaction()
                val fragment1: showdata_fragment = showdata_fragment()
                mfragmenttransaction?.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_right)
                mfragmenttransaction?.addToBackStack(null)
                //mfragmenttransaction?.remove(fragment)
                //mfragmenttransaction?.add(R.id.frameLayout1,fragment1,"showdata_fragment")?.commit()
                mfragmenttransaction?.replace(R.id.frameLayout,fragment1,"showdata_fragment")?.commit()
                val bundle = Bundle()
                bundle.putString("memail",email.text.toString())
                bundle.putString("mpassword",password.text.toString())
                fragment1.arguments = bundle
                //mfragmenttransaction?.add(R.id.frameLayout1, mfragment)?.commit()
            }


        }



        return view
    }
    fun isValidString(str: String): Boolean{
        return emailPattern.matcher(str).matches()
    }
}


/*

// Inflates the custom fragment layout
val view: View = inflater.inflate(R.layout.my_custom_fragment, container, false)

// Finds the TextView in the custom fragment
myTextView = view.findViewById<View>(R.id.fragmentTextView) as TextView

// Gets the data from the passed bundle
val bundle = arguments
val message = bundle!!.getString("mText")

// Sets the derived data (type String) in the TextView
myTextView.text = message

return view*/


/*
// getting the bundle back from the android
val bundle = intent.extras

// performing the safety null check
var s:String? = null

// getting the string back
s = bundle!!.getString("key1", "Default"))*/
