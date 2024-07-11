package com.example.mysecondkotlinapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mysecondkotlinapp.ui.theme.MySecondKotlinAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var seriesAdapter: SeriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.series_list)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val series = obtenerSeriesDePrueba()

        seriesAdapter = SeriesAdapter(series) { serie ->
            val intent = Intent(this, TemporadasActivity::class.java)
            intent.putExtra("SERIE", serie)
            startActivity(intent)
        }
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = seriesAdapter
    }

    fun obtenerSeriesDePrueba(): List<Serie> {
        val generos = listOf("Drama", "Comedia", "Acción", "Ciencia Ficción", "Misterio", "Fantasía")

        return (1..20).map { serieId ->
            val genero = generos.random()
            Serie(
                id = serieId,
                nombre = "Serie $serieId: ${nombreAleatorio(genero)}",
                descripcion = "Una emocionante serie de $genero que te mantendrá al borde de tu asiento.",
                imageUrl = generarUrlImagenReal(),
                temporadas = (1..10).map { tempNum ->
                    Temporada(
                        numero = tempNum,
                        descripcion = "La temporada $tempNum lleva la historia a nuevas alturas con giros inesperados.",
                        capitulos = (1..15).map { capNum ->
                            Capitulo(
                                numero = capNum,
                                titulo = "Episodio $capNum: ${tituloAleatorio()}",
                                descripcion = "En este episodio, los personajes enfrentan desafíos que pondrán a prueba sus límites.",
                                linkToCapitulo = "https://ejemplo.com/serie$serieId/temporada$tempNum/capitulo$capNum"
                            )
                        }
                    )
                }
            )
        }
    }

    fun nombreAleatorio(genero: String): String {
        val adjetivos = listOf("Oscuro", "Brillante", "Secreto", "Eterno", "Perdido", "Último")
        val sustantivos = listOf("Destino", "Horizonte", "Camino", "Sueño", "Enigma", "Legado")
        return "El ${adjetivos.random()} ${sustantivos.random()} de $genero"
    }

    fun tituloAleatorio(): String {
        val frases = listOf(
            "La Revelación",
            "El Encuentro Inesperado",
            "Secretos Ocultos",
            "La Gran Decisión",
            "Un Nuevo Comienzo",
            "El Giro del Destino"
        )
        return frases.random()
    }

    fun generarUrlImagenReal(): String {
        val ancho = Random.nextInt(300, 800)
        val alto = Random.nextInt(400, 900)
        return "https://picsum.photos/$ancho/$alto"
    }
    }



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center) {
        Text(
            text = "Hoy gana el bucaros 5-0 $name!",
            modifier = modifier.padding(24.dp, 34.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MySecondKotlinAppTheme {
        Greeting("Android")
    }
}