package com.example.androidtest

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SuccessActivity : AppCompatActivity() {
    var phoneNumberChosen : String ="0919445464"
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        textView = findViewById(R.id.textView)
        val name= intent.getStringExtra("name")
        val successText = getString(R.string.success)
        textView.text="$name, $successText"
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun successButtonClicked(view: View) {
        val message = textView.text.toString()
        val phoneNumber=findViewById<TextView>(R.id.editTextPhone).text.toString()
        if(phoneNumber!="")
            phoneNumberChosen = phoneNumber
        val uri = Uri.parse("smsto:$phoneNumberChosen")
        val smsIntent = Intent(Intent.ACTION_SENDTO, uri)
        smsIntent.putExtra("sms_body", message)
        val chooser: Intent = Intent.createChooser(smsIntent, "Share")
        if (smsIntent.resolveActivity(packageManager) != null)
            startActivity(chooser)
        else
            Toast.makeText(this, "No SMS app found", Toast.LENGTH_SHORT).show()
    }

    fun radioButton1(view: View) {
        val radioGroup: RadioGroup = findViewById(R.id.RadioGroup)
        val choice = radioGroup.checkedRadioButtonId
        val chosenButton : RadioButton = findViewById(choice)
        //Toast.makeText(this, choice.toString(), Toast.LENGTH_SHORT).show()
        phoneNumberChosen = chosenButton.text.toString()
        Toast.makeText(this, phoneNumberChosen, Toast.LENGTH_SHORT).show()
    }
    fun radioButton2(view: View) {
        val radioGroup: RadioGroup = findViewById(R.id.RadioGroup)
        val choice = radioGroup.checkedRadioButtonId
        val chosenButton : RadioButton = findViewById(choice)
        //Toast.makeText(this, choice.toString(), Toast.LENGTH_SHORT).show()
        phoneNumberChosen = chosenButton.text.toString()
        Toast.makeText(this, phoneNumberChosen, Toast.LENGTH_SHORT).show()
    }
    fun radioButton3(view: View) {
        val radioGroup: RadioGroup = findViewById(R.id.RadioGroup)
        val choice = radioGroup.checkedRadioButtonId
        val chosenButton : RadioButton = findViewById(choice)
        //Toast.makeText(this, choice.toString(), Toast.LENGTH_SHORT).show()
        phoneNumberChosen = chosenButton.text.toString()
        Toast.makeText(this, phoneNumberChosen, Toast.LENGTH_SHORT).show()
    }
}
