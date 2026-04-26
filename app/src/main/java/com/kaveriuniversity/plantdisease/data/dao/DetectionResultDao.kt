package com.kaveriuniversity.plantdisease.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kaveriuniversity.plantdisease.data.model.DetectionResult
import kotlinx.coroutines.flow.Flow

@Dao
interface DetectionResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetectionResult(result: DetectionResult): Long

    @Update
    suspend fun updateDetectionResult(result: DetectionResult)

    @Delete
    suspend fun deleteDetectionResult(result: DetectionResult)

    @Query("SELECT * FROM detection_results WHERE id = :id")
    suspend fun getDetectionResultById(id: Int): DetectionResult?

    @Query("SELECT * FROM detection_results ORDER BY timestamp DESC")
    fun getAllDetectionResults(): Flow<List<DetectionResult>>

    @Query("SELECT * FROM detection_results WHERE plantName = :plantName ORDER BY timestamp DESC")
    fun getDetectionResultsByPlant(plantName: String): Flow<List<DetectionResult>>

    @Query("SELECT * FROM detection_results WHERE isHealthy = :isHealthy ORDER BY timestamp DESC")
    fun getDetectionResultsByHealth(isHealthy: Boolean): Flow<List<DetectionResult>>

    @Query("SELECT * FROM detection_results ORDER BY timestamp DESC LIMIT :limit")
    fun getRecentDetections(limit: Int): Flow<List<DetectionResult>>

    @Query("DELETE FROM detection_results")
    suspend fun clearAllResults()

    @Query("SELECT COUNT(*) FROM detection_results")
    suspend fun getDetectionCount(): Int
}
