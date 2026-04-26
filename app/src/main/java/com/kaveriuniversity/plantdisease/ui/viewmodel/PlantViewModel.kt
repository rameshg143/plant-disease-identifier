package com.kaveriuniversity.plantdisease.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kaveriuniversity.plantdisease.data.database.PlantDiseaseDatabase
import com.kaveriuniversity.plantdisease.data.model.Plant
import com.kaveriuniversity.plantdisease.data.repository.PlantRepository
import kotlinx.coroutines.launch

class PlantViewModel(application: Application) : AndroidViewModel(application) {
    private val database = PlantDiseaseDatabase.getInstance(application)
    private val repository = PlantRepository(database.plantDao())

    val allPlants = repository.getAllPlants()

    fun searchPlants(query: String) = repository.searchPlants(query)

    fun insertPlants(plants: List<Plant>) {
        viewModelScope.launch {
            repository.insertPlants(plants)
        }
    }
}
