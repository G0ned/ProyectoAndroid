package com.example.proyectoandroid.reservas.viewmodels

import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectoandroid.reservas.models.Asignaturas
import com.example.proyectoandroid.reservas.models.AsignaturasProv
import com.example.proyectoandroid.reservas.models.Usuarios
import com.example.proyectoandroid.reservas.models.UsuariosProv

class AsignaturaViewModels : ViewModel() {

     val listaAsignaturas = MutableLiveData<MutableList<Asignaturas>>()

     fun initAsignaturas() {
        listaAsignaturas.postValue(AsignaturasProv.listAsignaturas)
     }


}