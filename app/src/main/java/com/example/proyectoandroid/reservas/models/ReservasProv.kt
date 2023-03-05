package com.example.proyectoandroid.reservas.models


//clase que en la que se guardan los datos de prueba que vamos a utilizar en las reservas.
class ReservasProv {

    companion object {


        //método que añade una reserva a la lista.
        fun addReservas(reservas: Reservas) {

            reservasList.add(reservas)

        }

        fun removeReservas(reserva : Reservas) {

            reservasList.remove(reserva)

        }


        var reservasList = mutableListOf<Reservas>(


            Reservas(
                "10/03/2023",
                "ProfeESO",
                "ESO1A",
                "MEDUSA1",
                "1",
                0

            ),
            Reservas(
                "10/03/2023",
                "ProfeESO",
                "ESO2B",
                "MEDUSA1",
                "4",
                0

            ),
            Reservas(
                "10/03/2023",
                "ProfeFP",
                "CFGMFORESTALES2",
                "MEDUSA2",
                "1",
                0

            )


        )


    }
}