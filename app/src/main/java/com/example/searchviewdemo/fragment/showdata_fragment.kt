package com.example.searchviewdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.searchviewdemo.R

class showdata_fragment : Fragment() {

    private lateinit var showemail:EditText
    private lateinit var showpassword: EditText


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        var view: View = inflater.inflate(R.layout.showdata_fragment, container, false)
        

        showemail = view.findViewById(R.id.showdata_email)
        showpassword = view.findViewById(R.id.showdata_password)

        val bundle = arguments?.getString("memail")
        val bundle1 = arguments?.getString("mpassword")
        showemail.setText(bundle)
        showpassword.setText(bundle1)

        return view
    }

    override fun onPause() {
        super.onPause()
        requireActivity().finish()
    }
}

/*

// getting the bundle back from the android
val bundle = intent.extras

// performing the safety null check
var s:String? = null

// getting the string back
s = bundle!!.getString("key1", "Default"))*/
