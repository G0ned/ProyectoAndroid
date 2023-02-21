package com.example.proyectoandroid.incidencias.views.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoandroid.databinding.ItemIncidenciaBinding
import com.example.proyectoandroid.incidencias.models.Incidencias

class IncidenciasViewHolder(view:View):RecyclerView.ViewHolder(view){

    val binding = ItemIncidenciaBinding.bind(view)

    fun render (incidenciaModel: Incidencias, Listener :(Incidencias) -> Unit){
        binding.incidenciaFecha.text = incidenciaModel.fecha
        binding.incidenciaProfesor.text = incidenciaModel.profesor
        binding.incidenciaDescripcion.text = incidenciaModel.descripcion
        itemView.setOnClickListener { Listener(incidenciaModel) }

    }

}