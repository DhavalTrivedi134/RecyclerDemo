package com.example.searchviewdemo.activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.appcompat.widget.AppCompatSpinner
import com.example.searchviewdemo.R
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class TextInputLayoutActivity : AppCompatActivity() {
    lateinit var city: AppCompatSpinner
    lateinit var empname: AppCompatEditText
    lateinit var textinputempname: TextInputLayout
    lateinit var empdesignation: AppCompatEditText
    lateinit var textinputempdesignatrion: TextInputLayout
    lateinit var empmobileno: AppCompatEditText
    lateinit var textinputempmobileno: TextInputLayout
    lateinit var empemail: AppCompatEditText
    lateinit var textinputempemail: TextInputLayout
    private lateinit var male: AppCompatRadioButton
    lateinit var female: AppCompatRadioButton
    lateinit var bachlor: CheckBox
    lateinit var master: CheckBox
    lateinit var mphill: CheckBox
    lateinit var phd: CheckBox
    lateinit var submit: Button
    lateinit var addemp: Button
    lateinit var viewemp: Button
    lateinit var gender: RadioGroup
    var emailPattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_input_layout)

        supportActionBar?.title = "Employee Details"

        city = findViewById(R.id.spinnerCity)
        empname = findViewById(R.id.emp_name1)
        textinputempname = findViewById(R.id.emp_name)
        empdesignation = findViewById(R.id.emp_designation1)
        textinputempdesignatrion = findViewById(R.id.emp_designation)
        empmobileno = findViewById(R.id.emp_mobile_number1)
        textinputempmobileno = findViewById(R.id.emp_mobile_number)
        empemail = findViewById(R.id.emp_email_address1)
        textinputempemail = findViewById(R.id.emp_email_address)
        male = findViewById(R.id.emp_male)
        female = findViewById(R.id.emp_female)
        bachlor = findViewById(R.id.emp_bachlor)
        master = findViewById(R.id.emp_master)
        mphill = findViewById(R.id.emp_mphill)
        phd = findViewById(R.id.emp_Phd)
        submit = findViewById(R.id.emp_submit1)
        addemp = findViewById(R.id.emp_add)
        viewemp = findViewById(R.id.emp_view)
        gender = findViewById(R.id.emp_gender)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.city,
            android.R.layout.simple_spinner_dropdown_item
        )
        city.adapter = adapter

        empname.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus){
                if (empname.text.toString().isEmpty()) {
                    textinputempname.error = "Please Enter Employee name"
                } else{
                    textinputempname.error = ""
                }
            }
        }

        submit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                /*   var isValid : Boolean = true
                   if (empname.text.toString().isEmpty()){
                       textinputempname.setError("Please Enter Employee name")
                       return
                   }
                   else{
                       textinputempname.setError("")
                   }*/
                if (empname.text.toString().isEmpty()) {
                    textinputempname.setError("Please Enter Employee name")
                    return
                } else if (empdesignation.text.toString() == "") {
                    textinputempdesignatrion.setError("Please Enter Employee Designation")
                } else if (empmobileno.text.toString() == "") {
                    empmobileno.setError("Please Enter Mobile number")
                } else if (empemail.text.toString() == "") {
                    empemail.setError("Please Enter Email Address")
                } else if (!isValidString(empemail.text.toString())) {
                    empemail.setError("Please Enter Valid Email Address")
                } else if (city.selectedItem.toString() == "Select City") {
                    Toast.makeText(this@TextInputLayoutActivity, "Please Select City", Toast.LENGTH_SHORT).show()
                } else if (gender.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this@TextInputLayoutActivity, "Please Select Gender", Toast.LENGTH_SHORT).show()
                } else if (bachlor.isChecked == false && master.isChecked == false && mphill.isChecked == false && phd.isChecked == false) {
                    Toast.makeText(this@TextInputLayoutActivity, "Please Select hobby", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@TextInputLayoutActivity, "Data submitted successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })

        addemp.setOnClickListener(object : View.OnClickListener{

            override fun onClick(p0: View?) {

                if (empname.text.toString() == "") {
                    empname.setError("Please Enter Employee name")
                } else if (empdesignation.text.toString() == "") {
                    empdesignation.setError("Please Enter Employee Designation")
                } else if (empmobileno.text.toString() == "") {
                    empmobileno.setError("Please Enter Mobile number")
                } else if (empemail.text.toString() == "") {
                    empemail.setError("Please Enter Email Address")
                } else if (!isValidString(empemail.text.toString())) {
                    empemail.setError("Please Enter Valid Email Address")
                } else if (city.selectedItem.toString() == "Select City") {
                    Toast.makeText(this@TextInputLayoutActivity, "Please Select City", Toast.LENGTH_SHORT).show()
                } else if (gender.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this@TextInputLayoutActivity, "Please Select Gender", Toast.LENGTH_SHORT).show()
                } else if (bachlor.isChecked == false && master.isChecked == false && mphill.isChecked == false && phd.isChecked == false) {
                    Toast.makeText(this@TextInputLayoutActivity, "Please Select hobby", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@TextInputLayoutActivity, "Data submitted successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }

        })
    }
    fun isValidString(str: String): Boolean{
        return emailPattern.matcher(str).matches()
    }
}