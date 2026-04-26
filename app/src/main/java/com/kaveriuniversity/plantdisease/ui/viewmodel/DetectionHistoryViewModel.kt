package com.kaveriuniversity.plantdisease.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kaveriuniversity.plantdisease.data.database.PlantDiseaseDatabase
import com.kaveriuniversity.plantdisease.data.model.DetectionResult
import com.kaveriuniversity.plantdisease.data.repository.DetectionResultRepository
import kotlinx.coroutines.launch

class DetectionHistoryViewModel(application: Application) : AndroidViewModel(application) {
    private val database = PlantDiseaseDatabase.getInstance(application)
    private val repository = DetectionResultRepository(database.detectionResultDao())

    val allDetections = repository.getAllDetectionResults()

    fun deleteDetectionResult(result: DetectionResult) {
        viewModelScope.launch {
            repository.deleteDetectionResult(result)
        }
    }

    fun clearAllResults() {
        viewModelScope.launch {
            repository.clearAllResults()
        }
    }

    fun getDetectionCount() = repository.getDetectionCount()
}
