package com.example.proyectoandroid.incidencias.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectoandroid.incidencias.models.Incidencias
import com.example.proyectoandroid.incidencias.models.IncidenciasProv

// clase que se encarga de la tranferencia de datos entre los modelos y los fragmentos de incidencias.
class IncidenciasViewModel : ViewModel() {

    var listaIncidencias = MutableLiveData<MutableList<Incidencias>>()


    fun getIncidencias()   {
        listaIncidencias.postValue(IncidenciasProv.incidenciasList)

    }

    fun filtrarIncidencias(listaFiltrada : List<Incidencias>) {
        listaIncidencias.postValue(listaFiltrada.toMutableList())
    }


}