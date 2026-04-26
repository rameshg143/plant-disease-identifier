package com.kaveriuniversity.plantdisease.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kaveriuniversity.plantdisease.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupAboutContent()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "About App"
    }

    private fun setupAboutContent() {
        // Content is defined in layout file
        binding.tvDeveloper.text = "Developed by: Dr Shyam Kishore G"
        binding.tvUniversity.text = "KAVERI UNIVERSITY\nDepartment of Agricultural Technology"
        binding.tvWebsite.text = "www.kaveriuniversity.edu.in"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
