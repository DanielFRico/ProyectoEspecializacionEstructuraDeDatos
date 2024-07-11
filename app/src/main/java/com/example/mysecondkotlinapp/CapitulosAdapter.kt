package com.example.mysecondkotlinapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CapitulosAdapter(
    private val captitulos: List<Capitulo>,
    private val onItemClick: (Capitulo) -> Unit
) : RecyclerView.Adapter<CapitulosAdapter.CapituloViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CapituloViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_capitulo, parent, false)
        return CapituloViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: CapituloViewHolder, position: Int) {
        holder.bind(captitulos[position])
    }

    override fun getItemCount() = captitulos.size

    class CapituloViewHolder(itemView: View, val onItemClick: (Capitulo) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bind(capitulo: Capitulo) {
            itemView.findViewById<TextView>(R.id.textViewDescripcion).text = capitulo.descripcion
            itemView.findViewById<TextView>(R.id.textViewNumero).text = "Capitulo " + capitulo.numero.toString()
            itemView.setOnClickListener { onItemClick(capitulo) }
        }
    }
}