package com.kaveriuniversity.plantdisease.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class DiseaseWithRemedies(
    @Embedded
    val disease: Disease,
    @Relation(
        parentColumn = "id",
        entityColumn = "diseaseId"
    )
    val remedies: List<Remedy>
)
