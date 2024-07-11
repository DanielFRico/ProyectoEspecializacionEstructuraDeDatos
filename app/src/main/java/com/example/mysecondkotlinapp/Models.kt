package com.example.mysecondkotlinapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Serie(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val imageUrl: String,
    val temporadas: List<Temporada>
) : Parcelable

@Parcelize
data class Temporada(
    val numero: Int,
    val descripcion: String,
    val capitulos: List<Capitulo>
) : Parcelable

@Parcelize
data class Capitulo(
    val numero: Int,
    val titulo: String,
    val descripcion: String,
    val linkToCapitulo: String
) : Parcelable