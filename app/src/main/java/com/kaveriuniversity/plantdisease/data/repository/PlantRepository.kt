package com.kaveriuniversity.plantdisease.data.repository

import com.kaveriuniversity.plantdisease.data.dao.PlantDao
import com.kaveriuniversity.plantdisease.data.model.Plant
import kotlinx.coroutines.flow.Flow

class PlantRepository(private val plantDao: PlantDao) {
    fun getAllPlants(): Flow<List<Plant>> = plantDao.getAllPlants()

    fun searchPlants(query: String): Flow<List<Plant>> = plantDao.searchPlants(query)

    suspend fun getPlantById(id: Int): Plant? = plantDao.getPlantById(id)

    suspend fun insertPlant(plant: Plant) = plantDao.insertPlant(plant)

    suspend fun insertPlants(plants: List<Plant>) = plantDao.insertPlants(plants)

    suspend fun updatePlant(plant: Plant) = plantDao.updatePlant(plant)

    suspend fun deletePlant(plant: Plant) = plantDao.deletePlant(plant)

    suspend fun getPlantCount(): Int = plantDao.getPlantCount()
}
