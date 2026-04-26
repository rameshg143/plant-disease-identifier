package com.kaveriuniversity.plantdisease.ml

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.common.FileUtil
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import java.nio.MappedByteBuffer

class PlantClassifier(context: Context) {
    private var interpreter: Interpreter? = null
    private val imageProcessor: ImageProcessor
    private val inputImageBuffer: TensorImage
    private val modelInputSize = 224 // Standard input size for MobileNet

    init {
        try {
            val model = FileUtil.loadMappedFile(context, "plant_disease_model.tflite")
            interpreter = Interpreter(model, Interpreter.Options())
            imageProcessor = ImageProcessor.Builder()
                .add(ResizeOp(modelInputSize, modelInputSize, ResizeOp.ResizeMethod.BILINEAR))
                .build()
            inputImageBuffer = TensorImage(org.tensorflow.lite.DataType.UINT8)
        } catch (e: Exception) {
            Log.e("PlantClassifier", "Error loading model: ${e.message}")
        }
    }

    fun classifyPlant(bitmap: Bitmap): ClassificationResult {
        return try {
            inputImageBuffer.load(bitmap)
            val processedImage = imageProcessor.process(inputImageBuffer)

            val outputBuffer = Array(1) { FloatArray(1000) } // Standard ImageNet output size
            interpreter?.run(processedImage.buffer, outputBuffer)

            val predictions = outputBuffer[0]
            val (plantName, confidence) = getPredictions(predictions)

            ClassificationResult(
                plantName = plantName,
                confidence = confidence,
                isHealthy = confidence < 0.3 // Adjust threshold based on your model
            )
        } catch (e: Exception) {
            Log.e("PlantClassifier", "Error during classification: ${e.message}")
            ClassificationResult(
                plantName = "Unknown",
                confidence = 0f,
                isHealthy = false
            )
        }
    }

    private fun getPredictions(predictions: FloatArray): Pair<String, Float> {
        val maxIndex = predictions.indices.maxByOrNull { predictions[it] } ?: 0
        val confidence = predictions.getOrNull(maxIndex) ?: 0f
        val plantName = getPlantNameFromIndex(maxIndex)
        return Pair(plantName, confidence)
    }

    private fun getPlantNameFromIndex(index: Int): String {
        return when (index) {
            0 -> "Tomato"
            1 -> "Potato"
            2 -> "Pepper"
            3 -> "Corn"
            4 -> "Wheat"
            5 -> "Rice"
            6 -> "Sugarcane"
            7 -> "Cotton"
            8 -> "Apple"
            9 -> "Mango"
            else -> "Unknown Plant"
        }
    }

    fun close() {
        interpreter?.close()
    }
}

data class ClassificationResult(
    val plantName: String,
    val confidence: Float,
    val isHealthy: Boolean
)
