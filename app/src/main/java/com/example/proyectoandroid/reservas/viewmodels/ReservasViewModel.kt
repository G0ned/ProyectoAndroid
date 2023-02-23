package com.example.proyectoandroid.reservas.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.proyectoandroid.incidencias.models.Incidencias
import com.example.proyectoandroid.incidencias.models.IncidenciasProv
import com.example.proyectoandroid.reservas.models.Reservas
import com.example.proyectoandroid.reservas.models.ReservasProv

class ReservasViewModel {

    var listaReservas = MutableLiveData<MutableList<Reservas>>()


    fun getReservas()   {
        listaReservas.postValue(ReservasProv.reservasList)

    }

}