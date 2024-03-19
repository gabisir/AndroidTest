package com.example.androidtest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtest.data.UserAdapter
import com.example.androidtest.data.UserViewModel

class AnalyticsActivity : AppCompatActivity() {

    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        Toast.makeText(applicationContext, "GORI", Toast.LENGTH_SHORT).show()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.analytics_activity)

        // Find the RecyclerView from the layout
        val recyclerView: RecyclerView = findViewById(R.id.recycle)

        // Set layout manager for the RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize the adapter with an empty list
        userAdapter = UserAdapter(emptyList())

        // Set the adapter for the RecyclerView
        recyclerView.adapter = userAdapter

        // Retrieve ViewModel and observe LiveData as before
        val viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        viewModel.readAllData.observe(this) { userList ->
            Log.d("AnalyticsActivity", "User list size: ${userList.size}")

            // Update the adapter with the new user list
            userAdapter.updateList(userList)
        }
    }
}