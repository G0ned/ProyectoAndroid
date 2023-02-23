package com.example.proyectoandroid.reservas.models

// Clase donde se guardan la información de las reservas.
data class Reservas(
    val fecha :  String,
    val profesor : String,
    val grupo : String,
    val aula : String,
    val hora : String
)
