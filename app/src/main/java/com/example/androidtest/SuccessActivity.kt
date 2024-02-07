package com.example.androidtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SuccessActivity : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        textView = findViewById(R.id.textView)
        val name= intent.getStringExtra("name")
        textView.text="$name, uspješno ste napravili 10 koraka!"
    }

    fun successbuttonclicked(view: View) {
        val sms = Intent(Intent.ACTION_VIEW)
        startActivity(sms)
    }

}