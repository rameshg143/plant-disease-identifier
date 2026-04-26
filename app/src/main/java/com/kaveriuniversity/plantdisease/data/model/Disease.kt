package com.kaveriuniversity.plantdisease.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "diseases",
    foreignKeys = [
        ForeignKey(
            entity = Plant::class,
            parentColumns = ["id"],
            childColumns = ["plantId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Disease(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val plantId: Int,
    val name: String,
    val scientificName: String,
    val symptoms: String,
    val cause: String,
    val severity: String, // MILD, MODERATE, SEVERE
    val imageUrl: String,
    val description: String
)
