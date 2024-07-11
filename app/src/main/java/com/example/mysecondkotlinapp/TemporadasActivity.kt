package com.example.mysecondkotlinapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.squareup.picasso.Picasso

class TemporadasActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var temporadasAdapter: TemporadasAdapter
    private lateinit var titleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temporadas)
        recyclerView = findViewById(R.id.recyclerViewTemporadas)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val serie = intent.getParcelableExtra<Serie>("SERIE")

        if (serie == null) {
            finish()
            return
        }
        val imageView: ImageView = findViewById(R.id.cardImage)
        Picasso.get()
            .load(serie.imageUrl)
            .into(imageView)

        setTitle(serie.nombre)

        temporadasAdapter = TemporadasAdapter(serie.temporadas) { temporada ->
            val intent = Intent(this, CapitulosActivity::class.java)
            intent.putExtra("TEMPORADA", temporada)
            startActivity(intent)
        }
        recyclerView.adapter = temporadasAdapter
    }
}