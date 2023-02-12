package com.example.proyectoandroid.incidencias

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoandroid.databinding.FragmentIncidendiasBinding
import com.example.proyectoandroid.incidencias.adapter.IncidenciasAdapter
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
        val manager = LinearLayoutManager(context)
        val decoration = DividerItemDecoration(context,manager.orientation)
        binding.recyclerview.layoutManager=  manager
        binding.recyclerview.adapter = IncidenciasAdapter(IncidenciasProv.incidenciasList) {
            incidencias -> goToFullObject(incidencias)
        }
        binding.recyclerview.addItemDecoration(decoration)

    }

    fun goToFullObject( incidencias: Incidencias) {
        Toast.makeText(context,"OK",Toast.LENGTH_SHORT).show()

    }

}