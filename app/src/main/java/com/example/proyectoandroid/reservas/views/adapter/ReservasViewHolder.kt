package com.example.proyectoandroid.reservas.views.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoandroid.databinding.ItemReservasBinding
import com.example.proyectoandroid.reservas.models.Reservas

class ReservasViewHolder(view :View):RecyclerView.ViewHolder(view) {

    val binding = ItemReservasBinding.bind(view)

    fun render(reservasModel : Reservas, Listener :(Reservas) -> Unit  ){

        binding.reservasProfesor.text =  reservasModel.profesor
        binding.reservasFecha.text = reservasModel.fecha
        binding.reservasGrupo.text = reservasModel.grupo
        binding.reservasHora.text = reservasModel.hora
        itemView.setOnClickListener { Listener(reservasModel) }

    }

}