package com.example.androidtest


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    var counter = 0
    private lateinit var sharedPreferences: SharedPreferences
    companion object {
        const val SCORE_KEY = "score_key"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)

        counter = sharedPreferences.getInt(SCORE_KEY, 0)
        if(counter>=10)
            counter = 0
        val textView = findViewById<TextView>(R.id.Counter)
        textView.text = "$counter"

    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext, "onStart", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onStart")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext, "onPause", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onPause")
        val textView = findViewById<TextView>(R.id.Counter)
        val counterValue = textView.text.toString().toIntOrNull() ?: 0
        val editor = sharedPreferences.edit()
        editor.putInt(SCORE_KEY, counterValue)
        editor.apply()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext, "onResume", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(applicationContext, "onRestart", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext, "onDestroy", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onDestroy")

    }

    fun onButtonUpClicked(view: View) {
        counter++
        val text1: TextView = findViewById(R.id.Counter)
        text1.text = counter.toString()
        if(counter==10)
        {
            counter = 0
            val intent = Intent(this, SuccessActivity::class.java).apply{
                putExtra("name", findViewById<TextView>(R.id.plainTextName).text.toString())
            }
            startActivity(intent)
        }
    }
    fun onButtonDownClicked(view: View) {
        if(counter!=0)
            counter--
        val text1: TextView = findViewById(R.id.Counter)
        text1.text = counter.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("counter", counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt("counter", 0)
        findViewById<TextView>(R.id.Counter).text = counter.toString()
    }

    fun resetCounter(view: View) {
        counter = 0
        val text1: TextView = findViewById(R.id.Counter)
        text1.text = counter.toString()
    }

}