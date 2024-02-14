package com.example.androidtest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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
        val message = textView.text.toString()
        var phoneNumber=findViewById<TextView>(R.id.editTextPhone).text.toString()
        val defaultPhoneNumber="0919445464"
        if(phoneNumber=="")
            phoneNumber=defaultPhoneNumber
        val uri = Uri.parse("smsto:$phoneNumber")
        val smsIntent = Intent(Intent.ACTION_SENDTO, uri)
        smsIntent.putExtra("sms_body", message)

        val chooser: Intent = Intent.createChooser(smsIntent, "Share")

        if (smsIntent.resolveActivity(packageManager) != null)
            startActivity(chooser)
        else
            Toast.makeText(this, "No SMS app found", Toast.LENGTH_SHORT).show()
    }
}