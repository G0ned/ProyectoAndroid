package com.example.proyectoandroid.reservas.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectoandroid.reservas.models.Reservas
import com.example.proyectoandroid.reservas.models.ReservasProv


//Clase ReservasViewModel, se encarga de unir los datos de los modelos con los fragementos.
class ReservasViewModel : ViewModel() {

    var listaReservas = MutableLiveData<MutableList<Reservas>>()




    // método que se encarga de remplazar la información de la variable listaReservas.
    fun getReservas()   {
        listaReservas.postValue(ReservasProv.reservasList)

    }

    fun filtrarPorProfesor(profesor : String) :List<Reservas> {

        return listaReservas.value?.filter { reserva -> reserva.profesor.lowercase() == profesor.lowercase() } ?: emptyList()

    }

}