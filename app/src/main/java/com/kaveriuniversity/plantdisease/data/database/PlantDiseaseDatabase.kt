package com.kaveriuniversity.plantdisease.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kaveriuniversity.plantdisease.data.dao.DiseaseDao
import com.kaveriuniversity.plantdisease.data.dao.DetectionResultDao
import com.kaveriuniversity.plantdisease.data.dao.PlantDao
import com.kaveriuniversity.plantdisease.data.dao.RemedyDao
import com.kaveriuniversity.plantdisease.data.model.DetectionResult
import com.kaveriuniversity.plantdisease.data.model.Disease
import com.kaveriuniversity.plantdisease.data.model.Plant
import com.kaveriuniversity.plantdisease.data.model.Remedy

@Database(
    entities = [Plant::class, Disease::class, Remedy::class, DetectionResult::class],
    version = 1,
    exportSchema = false
)
abstract class PlantDiseaseDatabase : RoomDatabase() {
    abstract fun plantDao(): PlantDao
    abstract fun diseaseDao(): DiseaseDao
    abstract fun remedyDao(): RemedyDao
    abstract fun detectionResultDao(): DetectionResultDao

    companion object {
        @Volatile
        private var INSTANCE: PlantDiseaseDatabase? = null

        fun getInstance(context: Context): PlantDiseaseDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlantDiseaseDatabase::class.java,
                    "plant_disease_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
