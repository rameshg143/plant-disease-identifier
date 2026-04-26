package com.kaveriuniversity.plantdisease.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kaveriuniversity.plantdisease.data.model.DetectionResult
import com.kaveriuniversity.plantdisease.databinding.ItemDetectionResultBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetectionResultAdapter(
    private val onItemClick: (DetectionResult) -> Unit = {}
) : ListAdapter<DetectionResult, DetectionResultAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDetectionResultBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemDetectionResultBinding,
        private val onItemClick: (DetectionResult) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(result: DetectionResult) {
            binding.apply {
                tvPlantName.text = result.plantName
                tvDiseaseName.text = result.diseaseName ?: "Healthy"
                tvConfidence.text = "${(result.confidence * 100).toInt()}%"
                tvTimestamp.text = formatDate(result.timestamp)

                // Set status color
                if (result.isHealthy) {
                    tvStatus.text = "✓ Healthy"
                    tvStatus.setTextColor(
                        itemView.context.getColor(
                            android.R.color.holo_green_dark
                        )
                    )
                } else {
                    tvStatus.text = "⚠ Disease Detected"
                    tvStatus.setTextColor(
                        itemView.context.getColor(
                            android.R.color.holo_red_dark
                        )
                    )
                }

                root.setOnClickListener {
                    onItemClick(result)
                }
            }
        }

        private fun formatDate(timestamp: Long): String {
            val sdf = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault())
            return sdf.format(Date(timestamp))
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<DetectionResult>() {
        override fun areItemsTheSame(
            oldItem: DetectionResult,
            newItem: DetectionResult
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: DetectionResult,
            newItem: DetectionResult
        ): Boolean = oldItem == newItem
    }
}
