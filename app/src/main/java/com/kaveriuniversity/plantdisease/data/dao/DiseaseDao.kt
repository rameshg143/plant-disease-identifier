package com.kaveriuniversity.plantdisease.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kaveriuniversity.plantdisease.data.model.Disease
import com.kaveriuniversity.plantdisease.data.model.DiseaseWithRemedies
import kotlinx.coroutines.flow.Flow

@Dao
interface DiseaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDisease(disease: Disease): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDiseases(diseases: List<Disease>)

    @Update
    suspend fun updateDisease(disease: Disease)

    @Delete
    suspend fun deleteDisease(disease: Disease)

    @Query("SELECT * FROM diseases WHERE id = :id")
    suspend fun getDiseaseById(id: Int): Disease?

    @Query("SELECT * FROM diseases WHERE plantId = :plantId")
    fun getDiseasesByPlantId(plantId: Int): Flow<List<Disease>>

    @Query("SELECT * FROM diseases WHERE name LIKE '%' || :searchQuery || '%'")
    fun searchDiseases(searchQuery: String): Flow<List<Disease>>

    @Query("SELECT * FROM diseases ORDER BY name ASC")
    fun getAllDiseases(): Flow<List<Disease>>

    @Query("SELECT * FROM diseases WHERE id = :diseaseId")
    suspend fun getDiseaseWithRemedies(diseaseId: Int): DiseaseWithRemedies?
}
