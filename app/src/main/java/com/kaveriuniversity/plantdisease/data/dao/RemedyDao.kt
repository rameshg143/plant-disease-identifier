package com.kaveriuniversity.plantdisease.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kaveriuniversity.plantdisease.data.model.Remedy
import kotlinx.coroutines.flow.Flow

@Dao
interface RemedyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRemedy(remedy: Remedy): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRemedies(remedies: List<Remedy>)

    @Update
    suspend fun updateRemedy(remedy: Remedy)

    @Delete
    suspend fun deleteRemedy(remedy: Remedy)

    @Query("SELECT * FROM remedies WHERE id = :id")
    suspend fun getRemedyById(id: Int): Remedy?

    @Query("SELECT * FROM remedies WHERE diseaseId = :diseaseId")
    fun getRemediesByDiseaseId(diseaseId: Int): Flow<List<Remedy>>

    @Query("SELECT * FROM remedies WHERE type = :type ORDER BY effectiveness DESC")
    fun getRemediesByType(type: String): Flow<List<Remedy>>

    @Query("SELECT * FROM remedies ORDER BY effectiveness DESC LIMIT :limit")
    fun getTopRemedies(limit: Int): Flow<List<Remedy>>

    @Query("SELECT * FROM remedies WHERE diseaseId = :diseaseId AND type = :type")
    fun getRemediesByDiseaseAndType(diseaseId: Int, type: String): Flow<List<Remedy>>
}
