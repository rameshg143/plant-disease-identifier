package com.kaveriuniversity.plantdisease.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kaveriuniversity.plantdisease.data.database.PlantDiseaseDatabase
import com.kaveriuniversity.plantdisease.data.model.Disease
import com.kaveriuniversity.plantdisease.data.repository.DiseaseRepository
import kotlinx.coroutines.launch

class DiseaseViewModel(application: Application) : AndroidViewModel(application) {
    private val database = PlantDiseaseDatabase.getInstance(application)
    private val repository = DiseaseRepository(database.diseaseDao())

    val allDiseases = repository.getAllDiseases()

    fun searchDiseases(query: String) = repository.searchDiseases(query)

    fun getDiseasesByPlantId(plantId: Int) = repository.getDiseasesByPlantId(plantId)

    fun insertDiseases(diseases: List<Disease>) {
        viewModelScope.launch {
            repository.insertDiseases(diseases)
        }
    }
}
