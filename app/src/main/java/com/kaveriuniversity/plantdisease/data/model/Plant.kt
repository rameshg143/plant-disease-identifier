package com.kaveriuniversity.plantdisease.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plants")
data class Plant(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val scientificName: String,
    val description: String,
    val imageUrl: String,
    val familyName: String,
    val nativeRegion: String,
    val commonUses: String
)
