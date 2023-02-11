package com.example.proyectoandroid.incidencias.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoandroid.R
import com.example.proyectoandroid.incidencias.Incidencias

class IncidenciasViewHolder(view:View):RecyclerView.ViewHolder(view) {

    val fecha =  view.findViewById<TextView>(R.id.incidencia_fecha)
    val profesor = view.findViewById<TextView>(R.id.incidencia_profesor)
    val descripcion = view.findViewById<TextView>(R.id.incidencia_descripcion)

    fun render (incidenciaModel:Incidencias){
        fecha.text = incidenciaModel.fecha
        profesor.text = incidenciaModel.profesor
        descripcion.text = incidenciaModel.descripcion

    }

}