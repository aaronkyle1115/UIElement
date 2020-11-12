package com.example.uielement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity3 : AppCompatActivity() {
    private var firstname : String? = null
    private var lastname : String? = null
    private var emailadd : String? = null
    private var age : String? = null
    private var phone : String? = null
    private var date : String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var Fname = findViewById<TextView>(R.id.Fname)
        var Lname = findViewById<TextView>(R.id.Lname)
        var Email = findViewById<TextView>(R.id.Email)
        var Age = findViewById<TextView>(R.id.Age)
        var Phone = findViewById<TextView>(R.id.Phone)
        var Date = findViewById<TextView>(R.id.Date)

        intent?.let{
            firstname = it.getStringExtra("firstname")
            lastname = it.getStringExtra("lastname")
            emailadd = it.getStringExtra("emailadd")
            age = it.getStringExtra("age")
            phone = it.getStringExtra("phone")
            date = it.getStringExtra("birthdate")
        }

        Fname.text =  "FirstName: $firstname"
        Lname.text = "Lastname: $lastname"
        Email.text = "Email: $emailadd"
        Age.text = "Age: $age"
        Phone.text = "Phone#: $phone"
        Date.text = "BirthDate: $date"



    }
}