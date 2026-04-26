package com.kaveriuniversity.plantdisease.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class PlantWithDiseases(
    @Embedded
    val plant: Plant,
    @Relation(
        parentColumn = "id",
        entityColumn = "plantId"
    )
    val diseases: List<Disease>
)
