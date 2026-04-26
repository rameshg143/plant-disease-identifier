package com.kaveriuniversity.plantdisease.ml

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.common.FileUtil
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp

class DiseaseDetector(context: Context) {
    private var interpreter: Interpreter? = null
    private val imageProcessor: ImageProcessor
    private val inputImageBuffer: TensorImage
    private val modelInputSize = 224

    init {
        try {
            val model = FileUtil.loadMappedFile(context, "disease_detection_model.tflite")
            interpreter = Interpreter(model, Interpreter.Options())
            imageProcessor = ImageProcessor.Builder()
                .add(ResizeOp(modelInputSize, modelInputSize, ResizeOp.ResizeMethod.BILINEAR))
                .build()
            inputImageBuffer = TensorImage(org.tensorflow.lite.DataType.UINT8)
        } catch (e: Exception) {
            Log.e("DiseaseDetector", "Error loading model: ${e.message}")
        }
    }

    fun detectDisease(bitmap: Bitmap): DiseaseDetectionResult {
        return try {
            inputImageBuffer.load(bitmap)
            val processedImage = imageProcessor.process(inputImageBuffer)

            val outputBuffer = Array(1) { FloatArray(10) } // 10 disease classes
            interpreter?.run(processedImage.buffer, outputBuffer)

            val predictions = outputBuffer[0]
            val (diseaseName, confidence, severity) = analyzeDiseaseOutput(predictions)

            DiseaseDetectionResult(
                diseaseName = diseaseName,
                confidence = confidence,
                severity = severity,
                hasDisease = confidence > 0.5
            )
        } catch (e: Exception) {
            Log.e("DiseaseDetector", "Error during detection: ${e.message}")
            DiseaseDetectionResult(
                diseaseName = "Unable to detect",
                confidence = 0f,
                severity = "Unknown",
                hasDisease = false
            )
        }
    }

    private fun analyzeDiseaseOutput(predictions: FloatArray): Triple<String, Float, String> {
        val maxIndex = predictions.indices.maxByOrNull { predictions[it] } ?: 0
        val confidence = predictions.getOrNull(maxIndex) ?: 0f
        val diseaseName = getDiseaseNameFromIndex(maxIndex)
        val severity = determineSeverity(confidence)
        return Triple(diseaseName, confidence, severity)
    }

    private fun getDiseaseNameFromIndex(index: Int): String {
        return when (index) {
            0 -> "Early Blight"
            1 -> "Late Blight"
            2 -> "Septoria Leaf Spot"
            3 -> "Yellow Leaf Curl"
            4 -> "Powdery Mildew"
            5 -> "Rust"
            6 -> "Anthracnose"
            7 -> "Leaf Spot"
            8 -> "Bacterial Wilt"
            9 -> "Healthy"
            else -> "Unknown Disease"
        }
    }

    private fun determineSeverity(confidence: Float): String {
        return when {
            confidence >= 0.8 -> "SEVERE"
            confidence >= 0.6 -> "MODERATE"
            confidence >= 0.4 -> "MILD"
            else -> "MINIMAL"
        }
    }

    fun close() {
        interpreter?.close()
    }
}

data class DiseaseDetectionResult(
    val diseaseName: String,
    val confidence: Float,
    val severity: String,
    val hasDisease: Boolean
)
