package com.example.proyectoandroid.reservas.models

class ReservasProv {

    companion object {

        fun addReservas(reservas: Reservas) {

            reservasList.add(reservas)

        }


        var reservasList = mutableListOf<Reservas>(



        )


    }
}