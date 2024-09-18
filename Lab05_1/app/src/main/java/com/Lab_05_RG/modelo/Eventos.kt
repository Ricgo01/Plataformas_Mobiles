package com.Lab_05_RG.modelo

import kotlinx.serialization.Serializable

@Serializable
data class Eventos(
    val nombre: String,
    val artista: String,
    val fecha: String,
    val lugar: String,
    val descripcion: String,
    val imagen: Int
)