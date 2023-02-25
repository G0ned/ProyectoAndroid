package com.example.proyectoandroid.incidencias.views.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoandroid.databinding.ItemIncidenciaBinding
import com.example.proyectoandroid.incidencias.models.Incidencias


//Clase view holder para el recycler view de incidencias.
class IncidenciasViewHolder(view:View):RecyclerView.ViewHolder(view){


    //refernecia al archivo xml -> item_incidencia.xml en la carpeta layout
    val binding = ItemIncidenciaBinding.bind(view)


    fun render (incidenciaModel: Incidencias, Listener :(Incidencias) -> Unit){

        binding.incidenciaFecha.text = "Fecha: ${incidenciaModel.fechaIncidencias}"
        binding.incidenciaAulaGrupo.text = "Aula: ${incidenciaModel.codAula} Equipo: ${incidenciaModel.codEquipo} "
        binding.incidenciaDescripcion.text =  "Descripción: ${incidenciaModel.descripcion}"
        itemView.setOnClickListener { Listener(incidenciaModel) }

    }

}