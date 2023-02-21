package com.example.proyectoandroid.incidencias.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
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
    val incidenciasViewModel :IncidenciasViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentIncidendiasBinding.inflate(inflater,container,false)
        incidenciasViewModel.getIncidencias()
        initRecyclerView()
        return  binding.root


    }

    //metodo que inicializa los elementos del recyclerview siempre que la lista "listaIncidencia" del viewmodels es modificado.
    private fun initRecyclerView(){

        incidenciasViewModel.listaIncidencias.observe(viewLifecycleOwner, Observer {
            val manager = LinearLayoutManager(context)
            val adapter = IncidenciasAdapter(incidenciasViewModel.listaIncidencias.value?.toList() ?: emptyList()) {
                    incidencia -> goToFullObject(incidencia)
            }
            val decoration = DividerItemDecoration(context,manager.orientation)
            binding.recyclerview.layoutManager=  manager
            binding.recyclerview.adapter = adapter
            binding.recyclerview.addItemDecoration(decoration)
        })


    }



    //metodo  que envia la información del item selecionado al fragmento de verIncidenciasFragment.
    fun goToFullObject( incidencias: Incidencias) {
        Toast.makeText(context,incidencias.profesor, Toast.LENGTH_SHORT).show()
        val bundle = bundleOf(
            "profesor" to incidencias.profesor,
            "descripcion" to incidencias.descripcion,
            "fecha" to  incidencias.fecha

        )
        view?.findNavController()?.navigate(R.id.action_incidenciasFragment_to_verIncidenciasFragment, args = bundle)

    }

}