package com.example.proyectoandroid.reservas.views.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoandroid.databinding.ItemReservasBinding
import com.example.proyectoandroid.reservas.models.Reservas


//viewholder para las reservas.

class ReservasViewHolder(view :View):RecyclerView.ViewHolder(view) {

    // referencia del archivo xml -> item_reservas.xml en la carpeta layout.
    val binding = ItemReservasBinding.bind(view)


    // función que construyen los items del recyclerview.
    fun render(reservasModel : Reservas, Listener :(Reservas) -> Unit  ){
        binding.reservasProfesor.text =  reservasModel.profesor
        binding.reservasFecha.text = reservasModel.fecha
        binding.reservasGrupo.text = reservasModel.grupo
        binding.reservasHora.text = reservasModel.hora
        itemView.setOnClickListener { Listener(reservasModel) }

    }

}