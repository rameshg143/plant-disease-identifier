package com.kaveriuniversity.plantdisease.data.repository

import com.kaveriuniversity.plantdisease.data.dao.DiseaseDao
import com.kaveriuniversity.plantdisease.data.model.Disease
import com.kaveriuniversity.plantdisease.data.model.DiseaseWithRemedies
import kotlinx.coroutines.flow.Flow

class DiseaseRepository(private val diseaseDao: DiseaseDao) {
    fun getAllDiseases(): Flow<List<Disease>> = diseaseDao.getAllDiseases()

    fun getDiseasesByPlantId(plantId: Int): Flow<List<Disease>> =
        diseaseDao.getDiseasesByPlantId(plantId)

    fun searchDiseases(query: String): Flow<List<Disease>> = diseaseDao.searchDiseases(query)

    suspend fun getDiseaseById(id: Int): Disease? = diseaseDao.getDiseaseById(id)

    suspend fun getDiseaseWithRemedies(diseaseId: Int): DiseaseWithRemedies? =
        diseaseDao.getDiseaseWithRemedies(diseaseId)

    suspend fun insertDisease(disease: Disease) = diseaseDao.insertDisease(disease)

    suspend fun insertDiseases(diseases: List<Disease>) = diseaseDao.insertDiseases(diseases)

    suspend fun updateDisease(disease: Disease) = diseaseDao.updateDisease(disease)

    suspend fun deleteDisease(disease: Disease) = diseaseDao.deleteDisease(disease)
}
