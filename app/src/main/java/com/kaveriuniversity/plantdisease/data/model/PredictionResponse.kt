package com.kaveriuniversity.plantdisease.data.model

data class PredictionResponse(
    val plantName: String,
    val diseaseName: String?,
    val confidence: Float,
    val isHealthy: Boolean,
    val remedies: List<String>? = null,
    val description: String?
)
