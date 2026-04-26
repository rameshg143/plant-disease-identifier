package com.kaveriuniversity.plantdisease.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kaveriuniversity.plantdisease.databinding.ActivityResultsBinding

class ResultsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        loadResults()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Analysis Results"
    }

    private fun loadResults() {
        // TODO: Get results from intent and display them
        val plantName = intent.getStringExtra("plant_name") ?: "Unknown"
        val diseaseName = intent.getStringExtra("disease_name")
        val confidence = intent.getFloatExtra("confidence", 0f)
        val isHealthy = intent.getBooleanExtra("is_healthy", false)

        binding.tvPlantName.text = "Plant: $plantName"
        binding.tvConfidence.text = "Confidence: ${(confidence * 100).toInt()}%"

        if (isHealthy) {
            binding.tvDiseaseStatus.text = "Status: Healthy Plant"
        } else if (diseaseName != null) {
            binding.tvDiseaseStatus.text = "Disease: $diseaseName"
            binding.btnViewRemedy.isEnabled = true
            binding.btnViewRemedy.setOnClickListener {
                // TODO: Start remedy activity
            }
        } else {
            binding.tvDiseaseStatus.text = "Unable to determine status"
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
