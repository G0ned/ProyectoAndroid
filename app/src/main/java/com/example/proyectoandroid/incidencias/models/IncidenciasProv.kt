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
                "Se rompió un monitor",
                "MEDUSA1",
                "PANT10"
            ),
            Incidencias(
                "10/02/2023",
                "Un ordenador no enciende",
                "MEDUSA2",
                "TORRE10"
            ),

            Incidencias(
                "10/02/2023",
                "Un ordenador no enciende",
                "MEDUSA2",
                "TORRE11"
            ),
            Incidencias(
                "10/02/2023",
                "Un ordenador no enciende",
                "MEDUSA1",
                "TORRE10",
            ),
            Incidencias(
                "10/02/2023",
                "Un ordenador no enciende",
                "MEDUSA2",
                "PANT01",
            )
        )
    }
}