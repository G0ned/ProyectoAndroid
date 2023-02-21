package com.example.proyectoandroid.incidencias.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectoandroid.incidencias.models.Incidencias
import com.example.proyectoandroid.incidencias.models.IncidenciasProv

class IncidenciasViewModel : ViewModel() {

    var listaIncidencias = MutableLiveData<List<Incidencias>>()
    var incidencia = MutableLiveData<Incidencias>()

    fun getIncidencias()   {
        listaIncidencias.postValue(IncidenciasProv.incidenciasList)

    }


}