package com.example.proyectoandroid.incidencias.models

// clase que se encarga de proveernos datos de prueba y donde guardamos las incidencias nuevas...
class IncidenciasProv {
    companion object{

        fun addIncidencia(incidencia : Incidencias) {
            incidenciasList.add(incidencia)
        }


        var incidenciasList= mutableListOf(
            Incidencias(
                "11/02/2023",
                "Reinaldo",
                "Se rompió un moinitor"
            ),
            Incidencias(
                "10/02/2023",
                "Rayco",
                "Un ordenador no enciende"
            ),

            Incidencias(
                "10/02/2023",
                "Rayco",
                "Un ordenador no enciende"
            ),
            Incidencias(
                "10/02/2023",
                "Rayco",
                "Un ordenador no enciende"
            ),
            Incidencias(
                "10/02/2023",
                "Rayco",
                "Un ordenador no enciende"
            ), Incidencias(
                "10/02/2023",
                "Rayco",
                "Un ordenador no enciende"
            ),
            Incidencias(
                "10/02/2023",
                "Rayco",
                "Un ordenador no enciende"
            ),
            Incidencias(
                "10/02/2023",
                "Rayco",
                "Un ordenador no enciende"
            )
        )
    }
}