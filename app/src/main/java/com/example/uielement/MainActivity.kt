package com.example.uielement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ageV = findViewById<TextView>(R.id.ageView)
        var ageB = findViewById<SeekBar>(R.id.ageBar)
        var ageN : Int = 0
        var nameFirst = findViewById<EditText>(R.id.FirstName)
        var nameLast = findViewById<EditText>(R.id.LastName)
        var emailAdd = findViewById<EditText>(R.id.EmailAdd)
        var phoneNum = findViewById<EditText>(R.id.editTextPhone)
        var phoneToggle = findViewById<Switch>(R.id.switch1)
        var next = findViewById<Button>(R.id.Nextbtn)

        ageB.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                ageV.text = "Age: $progress"
                ageN = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        phoneToggle.setOnCheckedChangeListener({ _, isChecked ->
            if (isChecked)
                phoneNum.visibility = View.VISIBLE
            else
                phoneNum.visibility = View.INVISIBLE
        })

        next.setOnClickListener{
            val intent =  Intent(this, MainActivity2::class.java)
            val phoneN = if (phoneNum.visibility == View.VISIBLE)
                phoneNum.getText().toString()
            else
                "N/A"
            intent.putExtra("firstname", nameFirst.text.toString())
            intent.putExtra("lastname", nameLast.text.toString())
            intent.putExtra("emailadd", emailAdd.text.toString())
            intent.putExtra("age", ageN.toString())
            intent.putExtra("phone", phoneN)
            startActivity(intent)
        }



    }

}