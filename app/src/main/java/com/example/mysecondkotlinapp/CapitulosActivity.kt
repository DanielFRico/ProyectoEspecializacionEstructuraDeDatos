package com.example.mysecondkotlinapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CapitulosActivity: ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var capitulosAdapter: CapitulosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capitulos)

        recyclerView = findViewById(R.id.capitulos_list)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val temporada = intent.getParcelableExtra<Temporada>("TEMPORADA")
        if (temporada == null) {
            finish()
            return
        }

        setTitle("Temporada " + temporada.numero.toString())
        capitulosAdapter = CapitulosAdapter(temporada.capitulos) { capitulo ->
           Log.i("capitulo", capitulo.descripcion)
        }
        recyclerView.adapter = capitulosAdapter
    }
}