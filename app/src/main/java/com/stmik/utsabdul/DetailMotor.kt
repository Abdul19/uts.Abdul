package com.stmik.utsabdul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailMotor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_motor)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val motor = intent.getParcelableExtra<Motor>(MainActivity.INTENT_PARCELABLE)

        val imgMotor = findViewById<ImageView>(R.id.img_item_photo)
        val nameMotor = findViewById<TextView>(R.id.tv_item_name)
        val descMotor = findViewById<TextView>(R.id.tv_item_description)

        imgMotor.setImageResource(motor?.imgMotor!!)
        nameMotor.text = motor.nameMotor
        descMotor.text = motor.descMotor

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}