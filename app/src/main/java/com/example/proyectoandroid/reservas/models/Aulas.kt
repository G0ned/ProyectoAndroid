package com.example.proyectoandroid.reservas.models

data class Aulas(

    val codigo : String,
    val CantidadTotal : Int,
    var CantidadDisponible : Int,
    var CantidadNoReservada : Int

)
