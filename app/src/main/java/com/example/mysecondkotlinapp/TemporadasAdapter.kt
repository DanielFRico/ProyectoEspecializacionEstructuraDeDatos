package com.example.mysecondkotlinapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TemporadasAdapter(
    private val series: List<Temporada>,
    private val onItemClick: (Temporada) -> Unit
) : RecyclerView.Adapter<TemporadasAdapter.TemporadaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemporadaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_temporada, parent, false)
        return TemporadaViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: TemporadaViewHolder, position: Int) {
        holder.bind(series[position])
    }

    override fun getItemCount() = series.size

    class TemporadaViewHolder(itemView: View, val onItemClick: (Temporada) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bind(temporada: Temporada) {
            itemView.findViewById<TextView>(R.id.textViewNumeroTemporada).text = "Temporada "+ temporada.numero.toString()
            itemView.findViewById<TextView>(R.id.textViewDescripcionTemporada).text = temporada.descripcion
            itemView.setOnClickListener { onItemClick(temporada) }
        }
    }
}