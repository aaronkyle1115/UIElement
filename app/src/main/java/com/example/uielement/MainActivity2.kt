package com.example.uielement

import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    private var date : String? = null
    private var firstname : String? = null
    private var lastname : String? = null
    private var emailadd : String? = null
    private var age : String? = null
    private var phone : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val signUP = findViewById<Button>(R.id.Sign)
        val calendar_view = findViewById<CalendarView>(R.id.calendarView)


        calendar_view.setOnDateChangeListener(object : CalendarView.OnDateChangeListener {
            override fun onSelectedDayChange(p0: CalendarView, p1: Int, p2: Int, p3: Int) {
                date = "$p3/${p2 + 1}/$p1"
                Toast.makeText(
                        this@MainActivity2,
                        "The selected date is $p3/${p2 + 1}/$p1",
                        Toast.LENGTH_SHORT
                ).show()
            }
        })

        signUP.setOnClickListener {
            openNextTask()
        }
    }


    public fun openNextTask() {
        val intent = Intent(this, MainActivity3::class.java)
        getstuff()
        intent.putExtra("firstname", firstname)
        intent.putExtra("lastname", lastname)
        intent.putExtra("emailadd", emailadd)
        intent.putExtra("age", age)
        intent.putExtra("phone", phone)
        intent.putExtra("birthdate", date.toString())
        startActivity(intent)
    }

    private fun getstuff(){
        intent?.let{
            firstname = it.getStringExtra("firstname")
            lastname = it.getStringExtra("lastname")
            emailadd = it.getStringExtra("emailadd")
            age = it.getStringExtra("age")
            phone = it.getStringExtra("phone")
        }
    }
}