package com.example.proyectoandroid.incidencias.views.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoandroid.R
import com.example.proyectoandroid.incidencias.models.Incidencias


class IncidenciasAdapter(private var incidencialist :List<Incidencias>, private val Listener :(Incidencias) -> Unit) : RecyclerView.Adapter<IncidenciasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncidenciasViewHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
    return IncidenciasViewHolder(layoutInflater.inflate(R.layout.item_incidencia, parent, false))
    }

    override fun getItemCount(): Int = incidencialist.size


    override fun onBindViewHolder(holder: IncidenciasViewHolder, position: Int) {
       val item = incidencialist[position]
        holder.render(item,Listener)



    }



}