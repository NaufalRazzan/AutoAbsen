package com.example.autoabsen

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraintLayout: ConstraintLayout = findViewById(R.id.mainLayout) as ConstraintLayout
        val animationDrawable: AnimationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
        login_btn()
    }
    private fun login_btn(){
        val btn_login = findViewById(R.id.login) as Button
        val edit_ID = findViewById(R.id.enterID) as EditText
        val user_pass = findViewById<EditText>(R.id.userPassword)
        btn_login.setOnClickListener(){
            if(edit_ID.text.isNullOrEmpty() || user_pass.text.isNullOrEmpty()){45
                Toast.makeText(this, "Please fill your ID", Toast.LENGTH_SHORT).show()
            }
            else{
                if(edit_ID.text.toString().compareTo("12345") != 0 || user_pass.text.toString().compareTo("12345") != 0){
                    Toast.makeText(this, "Incorect ID or Password", Toast.LENGTH_SHORT).show()
                }
                else{
                    val menu = Intent(this, MainMenu::class.java)
                    startActivity(menu)
                }
            }
        }
    }
}