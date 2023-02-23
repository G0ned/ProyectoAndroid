package com.example.proyectoandroid.reservas.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoandroid.R
import com.example.proyectoandroid.reservas.models.Reservas

//adaptador para el recycler view del archivo xml -> fragment_mis_reservas.
class ReservasAdapter(private var reservasList : List<Reservas>, private  val Listener : (Reservas) -> Unit ):RecyclerView.Adapter<ReservasViewHolder>() {

    override fun getItemCount(): Int = reservasList.size

    override fun onBindViewHolder(holder: ReservasViewHolder, position: Int) {
        val item = reservasList[position]
        holder.render(item,Listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ReservasViewHolder(layoutInflater.inflate(R.layout.item_reservas,parent,false))
    }

}