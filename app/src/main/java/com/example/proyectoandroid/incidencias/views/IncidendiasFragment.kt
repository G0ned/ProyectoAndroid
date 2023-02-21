package com.example.proyectoandroid.incidencias.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentIncidendiasBinding
import com.example.proyectoandroid.incidencias.models.Incidencias
import com.example.proyectoandroid.incidencias.views.adapter.IncidenciasAdapter
import com.example.proyectoandroid.incidencias.viewmodels.IncidenciasViewModel

class IncidendiasFragment : Fragment() {

    private lateinit var binding: FragmentIncidendiasBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentIncidendiasBinding.inflate(inflater,container,false)
        initRecyclerView()
        return  binding.root


    }

    private fun initRecyclerView(){

        val incidenciasViewModel :IncidenciasViewModel by viewModels()

        incidenciasViewModel.getIncidencias()

        incidenciasViewModel.listaIncidencias.observe(viewLifecycleOwner, Observer {
            val manager = LinearLayoutManager(context)
            val adapter = IncidenciasAdapter(incidenciasViewModel.listaIncidencias.value ?: emptyList()) {
                    incidencias -> goToFullObject(incidencias)
            }
            val decoration = DividerItemDecoration(context,manager.orientation)
            binding.recyclerview.layoutManager=  manager
            binding.recyclerview.adapter = adapter
            binding.recyclerview.addItemDecoration(decoration)
        })


    }

    fun goToFullObject( incidencias: Incidencias) {
        view?.findNavController()?.navigate(R.id.action_incidenciasFragment_to_verIncidenciasFragment)

    }

}