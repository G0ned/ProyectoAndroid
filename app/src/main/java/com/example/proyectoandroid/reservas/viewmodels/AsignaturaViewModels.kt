package com.example.proyectoandroid.reservas.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.proyectoandroid.reservas.models.Asignaturas
import com.example.proyectoandroid.reservas.models.AsignaturasProv
import com.example.proyectoandroid.reservas.models.Usuarios
import com.example.proyectoandroid.reservas.models.UsuariosProv

class AsignaturaViewModels {

    private var listaAsignaturas = MutableLiveData<MutableList<Asignaturas>>(
       AsignaturasProv.listAsignaturas
    )


}