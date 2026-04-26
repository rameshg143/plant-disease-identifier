package com.kaveriuniversity.plantdisease.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "remedies",
    foreignKeys = [
        ForeignKey(
            entity = Disease::class,
            parentColumns = ["id"],
            childColumns = ["diseaseId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Remedy(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val diseaseId: Int,
    val type: String, // ORGANIC, CHEMICAL, CULTURAL
    val treatment: String,
    val activeIngredient: String? = null,
    val dosage: String? = null,
    val applicationMethod: String,
    val frequency: String,
    val duration: String,
    val precautions: String,
    val cost: String? = null,
    val effectiveness: Int, // 1-100 percentage
    val preventionTips: String
)
