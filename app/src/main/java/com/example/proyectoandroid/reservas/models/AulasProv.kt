package com.example.proyectoandroid.reservas.models

class AulasProv {

    companion object {

        fun getAulaTablets() : Aulas {

            return listaAulas.filter {

                Aula -> Aula.codigo == "TABLETS"

            }.last()

        }


        val listaAulas = mutableListOf<Aulas>(


            Aulas(
                "MEDUSA1",
                0,
                0,
                0
            ),
            Aulas(
                "MEDUSA2",
                0,
                0,
                0
            ),
            Aulas(
                "TABLETS",
                50,
                50,
                0
            )


        )



    }



}