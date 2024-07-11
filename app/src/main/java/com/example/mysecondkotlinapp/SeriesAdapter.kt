package com.example.mysecondkotlinapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class SeriesAdapter(
    private val series: List<Serie>,
    private val onItemClick: (Serie) -> Unit
) : RecyclerView.Adapter<SeriesAdapter.SerieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_serie, parent, false)
        return SerieViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: SerieViewHolder, position: Int) {
        holder.bind(series[position])
    }

    override fun getItemCount() = series.size

    class SerieViewHolder(itemView: View, val onItemClick: (Serie) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bind(serie: Serie) {
            val imageView: ImageView = itemView.findViewById(R.id.cardImage)
            Picasso.get()
                .load(serie.imageUrl)
                .into(imageView)
            itemView.findViewById<TextView>(R.id.textViewNombreSerie).text = serie.nombre
            itemView.findViewById<TextView>(R.id.cardDescription).text = serie.descripcion
            itemView.setOnClickListener { onItemClick(serie) }
        }
    }
}