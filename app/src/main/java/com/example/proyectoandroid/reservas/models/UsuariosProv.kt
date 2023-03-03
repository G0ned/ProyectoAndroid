package com.example.proyectoandroid.reservas.models

class UsuariosProv {


    companion object {
        var ListaDeUsuarios = mutableListOf<Usuarios>(

            Usuarios(
                "Profesor de ESO",
                "Profesorado",
                "profeESO",
                "123"
            ),
            Usuarios(
                "Profesor de FP",
                "Profesorado",
                "profeFP",
                "123"
            ),
            Usuarios(
                "Equipo Directivo",
                "ED",
                "EquipoDirectivo",
                "123"
            )

        )

    }



}