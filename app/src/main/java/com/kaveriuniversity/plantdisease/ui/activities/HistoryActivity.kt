package com.kaveriuniversity.plantdisease.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kaveriuniversity.plantdisease.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()
        loadHistory()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detection History"
    }

    private fun setupRecyclerView() {
        binding.rvDetectionHistory.layoutManager = LinearLayoutManager(this)
        // TODO: Set adapter
    }

    private fun loadHistory() {
        // TODO: Load detection results from database and display in RecyclerView
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
