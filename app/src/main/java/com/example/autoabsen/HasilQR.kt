package com.example.autoabsen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HasilQR : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_qr)
        reScan()
    }

    private fun reScan(){
        val rScan = findViewById(R.id.backQR) as Button
        rScan.setOnClickListener(){
            val retScan = Intent(this, QRScanner::class.java)
            startActivity(retScan)
        }
    }
}