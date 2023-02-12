package com.example.proyectoandroid.incidencias

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentIncidendiasBinding
import com.example.proyectoandroid.incidencias.adapter.IncidenciasAdapter
import com.example.proyectoandroid.incidencias.viewmodels.IncidenciasList

class IncidendiasFragment : Fragment() {

    private lateinit var binding: FragmentIncidendiasBinding
    private var IncidenciasList : List<Incidencias> = IncidenciasProv.incidenciasList
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentIncidendiasBinding.inflate(inflater,container,false)
        initRecyclerView()
        return  binding.root


    }

    private fun initRecyclerView(){
        val manager = LinearLayoutManager(context)
        val adapter = IncidenciasAdapter(IncidenciasList) {
                incidencias -> goToFullObject(incidencias)
        }
        val decoration = DividerItemDecoration(context,manager.orientation)
        binding.recyclerview.layoutManager=  manager
        binding.recyclerview.adapter = adapter
        binding.recyclerview.addItemDecoration(decoration)



        val incidenciasList : IncidenciasList by activityViewModels()
        incidenciasList.list_Origen = IncidenciasList

        adapter.update(incidenciasList.list_Origen)

    }

    fun goToFullObject( incidencias: Incidencias) {
        view?.findNavController()?.navigate(R.id.action_incidenciasFragment_to_verIncidenciasFragment)


    }

}