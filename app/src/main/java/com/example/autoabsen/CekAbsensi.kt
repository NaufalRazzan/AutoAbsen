package com.example.autoabsen

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.graphics.drawable.AnimationDrawable
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*

var dateString = String()
class CekAbsensi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cek_absensi)
        var tv = findViewById<TextView>(R.id.tv_datePicker)

        val constraintLayout: ConstraintLayout = findViewById(R.id.cekLayout)
        val animationDrawable: AnimationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()

        val ShiftStart = "13.20"
        val ShiftEnds = "15.50"
        findName(ShiftStart, ShiftEnds)
        datePicker(tv)

    }
    private fun findName(ShiftStart: String, ShiftEnds: String){
        val findName = findViewById<Button>(R.id.find)
        var searchName = findViewById<EditText>(R.id.personName)
        val tvName = findViewById<TextView>(R.id.viewName)
        val tvHour = findViewById<TextView>(R.id.viewHours)
        findName.setOnClickListener(){
            if(searchName.text.isNullOrEmpty() || dateString.isNullOrEmpty()){
                Toast.makeText(this, "Please fill the blanks", Toast.LENGTH_SHORT).show()
            }
            // default name = "A" and date = "30/3/2022"
            else if(searchName.text.toString().compareTo("A") != 0 || dateString.compareTo("30/3/2022") != 0){
                Toast.makeText(this, "The name ${searchName.text} has no shift on $dateString", Toast.LENGTH_LONG).show()
            }
            else{
                val tvName = findViewById<TextView>(R.id.viewName)
                val tvHours = findViewById<TextView>(R.id.viewHours)
                val absent = findViewById<TextView>(R.id.isAbsent)
                val present = findViewById<TextView>(R.id.isPresent)
                // jika telat -> isABsent = true, jika tepat waktu -> isAbsent = false
                val isAbsent: Boolean = false

                if(isAbsent == false){
                    tvName.text = "A"
                    tvHour.text = "$ShiftStart - $ShiftEnds"
                    present.text = "ON TIME"
                }
            }
        }
    }

    private fun datePicker(tv: TextView){
        var cal = Calendar.getInstance()
        var myyear = cal.get(Calendar.YEAR)
        var mymonth = cal.get(Calendar.MONTH)
        var day = cal.get(Calendar.DAY_OF_MONTH)
        tv.setOnClickListener(){
            var datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                day = dayOfMonth
                mymonth = month + 1
                myyear = year
                tv.text = "$day/$mymonth/$myyear"
                dateString = day.toString() + "/" + mymonth.toString() + "/" + myyear.toString()
            },myyear, mymonth, day)
            datePickerDialog.show()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }
}