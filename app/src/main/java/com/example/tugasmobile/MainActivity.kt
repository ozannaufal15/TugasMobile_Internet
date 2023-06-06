package com.example.tugasmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataAdapter: DataAdapter
    private lateinit var buttonRefresh: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        buttonRefresh = findViewById(R.id.buttonRefresh)
        buttonRefresh.setOnClickListener {
            fetchData()
        }

        fetchData()
    }

    private fun fetchData() {
        val apiService = ApiClient.apiService
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val response = apiService.getJokes()
                dataAdapter = DataAdapter(response)
                recyclerView.adapter = dataAdapter
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Pengambilan data gagal", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        }
    }
}
