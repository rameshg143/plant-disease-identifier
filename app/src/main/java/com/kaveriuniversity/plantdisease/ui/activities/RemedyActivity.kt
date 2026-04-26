package com.kaveriuniversity.plantdisease.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kaveriuniversity.plantdisease.databinding.ActivityRemedyBinding

class RemedyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRemedyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRemedyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        loadRemedy()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Treatment Recommendations"
    }

    private fun loadRemedy() {
        // TODO: Get remedy data from intent and display
        val diseaseName = intent.getStringExtra("disease_name") ?: "Unknown Disease"
        val symptoms = intent.getStringExtra("symptoms") ?: ""
        val treatment = intent.getStringExtra("treatment") ?: ""
        val prevention = intent.getStringExtra("prevention") ?: ""

        binding.tvDiseaseName.text = diseaseName
        binding.tvSymptoms.text = symptoms
        binding.tvTreatment.text = treatment
        binding.tvPrevention.text = prevention

        binding.btnSaveRemedy.setOnClickListener {
            // TODO: Save remedy to database
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
