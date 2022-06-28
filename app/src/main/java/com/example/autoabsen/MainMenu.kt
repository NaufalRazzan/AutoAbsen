package com.example.autoabsen

import android.content.DialogInterface
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val constraintLayout: ConstraintLayout = findViewById(R.id.menuLayout)
        val animationDrawable: AnimationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
        toScan()
        toCek()
    }
    private fun toScan(){
        val QR_scn = findViewById(R.id.scan) as Button
        QR_scn.setOnClickListener(){
            val QR = Intent(this, QRScanner::class.java)
            startActivity(QR)

             // buat bypass QR Scanner
            /*val QR = Intent(this, HasilQR::class.java)*/
            startActivity(QR)

        }
    }

    private fun toCek(){
        val cek = findViewById<Button>(R.id.absen)
        cek.setOnClickListener(){
            val ckAbsen = Intent(this, CekAbsensi::class.java)
            startActivity(ckAbsen)
        }
    }

    override fun onBackPressed() {
        val confirm = AlertDialog.Builder(this)
        confirm.setTitle("Log out confirmation")
        confirm.setMessage("Do you want to logout?")
        confirm.setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
            finish()
        }
        confirm.setNegativeButton("No", { dialogInterface: DialogInterface, i: Int -> })
        confirm.show()
    }
}