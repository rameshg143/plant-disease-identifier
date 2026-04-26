package com.kaveriuniversity.plantdisease.data.repository

import com.kaveriuniversity.plantdisease.data.dao.RemedyDao
import com.kaveriuniversity.plantdisease.data.model.Remedy
import kotlinx.coroutines.flow.Flow

class RemedyRepository(private val remedyDao: RemedyDao) {
    fun getRemediesByDiseaseId(diseaseId: Int): Flow<List<Remedy>> =
        remedyDao.getRemediesByDiseaseId(diseaseId)

    fun getRemediesByType(type: String): Flow<List<Remedy>> = remedyDao.getRemediesByType(type)

    fun getTopRemedies(limit: Int = 10): Flow<List<Remedy>> = remedyDao.getTopRemedies(limit)

    fun getRemediesByDiseaseAndType(diseaseId: Int, type: String): Flow<List<Remedy>> =
        remedyDao.getRemediesByDiseaseAndType(diseaseId, type)

    suspend fun getRemedyById(id: Int): Remedy? = remedyDao.getRemedyById(id)

    suspend fun insertRemedy(remedy: Remedy) = remedyDao.insertRemedy(remedy)

    suspend fun insertRemedies(remedies: List<Remedy>) = remedyDao.insertRemedies(remedies)

    suspend fun updateRemedy(remedy: Remedy) = remedyDao.updateRemedy(remedy)

    suspend fun deleteRemedy(remedy: Remedy) = remedyDao.deleteRemedy(remedy)
}
