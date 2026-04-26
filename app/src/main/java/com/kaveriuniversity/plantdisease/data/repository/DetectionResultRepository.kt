package com.kaveriuniversity.plantdisease.data.repository

import com.kaveriuniversity.plantdisease.data.dao.DetectionResultDao
import com.kaveriuniversity.plantdisease.data.model.DetectionResult
import kotlinx.coroutines.flow.Flow

class DetectionResultRepository(private val detectionResultDao: DetectionResultDao) {
    fun getAllDetectionResults(): Flow<List<DetectionResult>> =
        detectionResultDao.getAllDetectionResults()

    fun getDetectionResultsByPlant(plantName: String): Flow<List<DetectionResult>> =
        detectionResultDao.getDetectionResultsByPlant(plantName)

    fun getDetectionResultsByHealth(isHealthy: Boolean): Flow<List<DetectionResult>> =
        detectionResultDao.getDetectionResultsByHealth(isHealthy)

    fun getRecentDetections(limit: Int = 20): Flow<List<DetectionResult>> =
        detectionResultDao.getRecentDetections(limit)

    suspend fun getDetectionResultById(id: Int): DetectionResult? =
        detectionResultDao.getDetectionResultById(id)

    suspend fun insertDetectionResult(result: DetectionResult) =
        detectionResultDao.insertDetectionResult(result)

    suspend fun updateDetectionResult(result: DetectionResult) =
        detectionResultDao.updateDetectionResult(result)

    suspend fun deleteDetectionResult(result: DetectionResult) =
        detectionResultDao.deleteDetectionResult(result)

    suspend fun clearAllResults() = detectionResultDao.clearAllResults()

    suspend fun getDetectionCount(): Int = detectionResultDao.getDetectionCount()
}
