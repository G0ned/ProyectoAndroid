package com.example.proyectoandroid.reservas.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoandroid.databinding.FragmentMisReservasBinding
import com.example.proyectoandroid.reservas.models.Reservas

import com.example.proyectoandroid.reservas.viewmodels.ReservasViewModel
import com.example.proyectoandroid.reservas.views.adapter.ReservasAdapter


class MisReservasFragment : Fragment() {

    private lateinit var  binding :  FragmentMisReservasBinding
    val reservasViewModelView : ReservasViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMisReservasBinding.inflate(inflater, container,false)
        reservasViewModelView.getReservas()
        InitRecyclerView()
        return binding.root
    }


    private fun InitRecyclerView() {

        reservasViewModelView.listaReservas.observe(viewLifecycleOwner, Observer {
            val manager = LinearLayoutManager(context)
            val adapter = ReservasAdapter(reservasViewModelView.listaReservas.value?.toList() ?: emptyList()) {
                reserva -> GoTofullReservas(reserva)
            }
            val decoration = DividerItemDecoration(context, manager.orientation)
            binding.recyclerviewMisReservas.layoutManager = manager
            binding.recyclerviewMisReservas.adapter = adapter
            binding.recyclerviewMisReservas.addItemDecoration(decoration)
        })

    }

    private  fun GoTofullReservas(reserva : Reservas) {



    }


}