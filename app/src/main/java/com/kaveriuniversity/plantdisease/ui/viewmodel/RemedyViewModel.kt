package com.kaveriuniversity.plantdisease.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kaveriuniversity.plantdisease.data.database.PlantDiseaseDatabase
import com.kaveriuniversity.plantdisease.data.model.Remedy
import com.kaveriuniversity.plantdisease.data.repository.RemedyRepository
import kotlinx.coroutines.launch

class RemedyViewModel(application: Application) : AndroidViewModel(application) {
    private val database = PlantDiseaseDatabase.getInstance(application)
    private val repository = RemedyRepository(database.remedyDao())

    fun getRemediesByDiseaseId(diseaseId: Int) = repository.getRemediesByDiseaseId(diseaseId)

    fun getRemediesByType(type: String) = repository.getRemediesByType(type)

    fun getTopRemedies(limit: Int = 10) = repository.getTopRemedies(limit)

    fun insertRemedies(remedies: List<Remedy>) {
        viewModelScope.launch {
            repository.insertRemedies(remedies)
        }
    }
}
