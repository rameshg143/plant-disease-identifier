package com.kaveriuniversity.plantdisease.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "detection_results",
    foreignKeys = [
        ForeignKey(
            entity = Plant::class,
            parentColumns = ["id"],
            childColumns = ["plantId"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = Disease::class,
            parentColumns = ["id"],
            childColumns = ["diseaseId"],
            onDelete = ForeignKey.SET_NULL
        )
    ]
)
data class DetectionResult(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val plantId: Int?,
    val diseaseId: Int?,
    val plantName: String,
    val diseaseName: String?,
    val confidence: Float,
    val isHealthy: Boolean,
    val timestamp: Long = System.currentTimeMillis(),
    val imagePath: String,
    val notes: String? = null
)
