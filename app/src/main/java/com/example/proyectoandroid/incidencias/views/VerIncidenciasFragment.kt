package com.example.proyectoandroid.incidencias.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.proyectoandroid.R
import com.example.proyectoandroid.databinding.FragmentVerIncidenciasBinding
import com.example.proyectoandroid.incidencias.models.Incidencias
import com.example.proyectoandroid.incidencias.viewmodels.IncidenciasViewModel

class VerIncidenciasFragment : Fragment() {

    private  lateinit var binding : FragmentVerIncidenciasBinding
    val incidenciasViewModel : IncidenciasViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding =   FragmentVerIncidenciasBinding.inflate(inflater, container, false)
        setData()
        return  binding.root
    }

    private fun setData() {
        binding.profesorIncContent.text = incidenciasViewModel.incidencia.value?.profesor
        binding.descIncContent.text = incidenciasViewModel.incidencia.value?.descripcion
        binding.fechaIncContent.text = incidenciasViewModel.incidencia.value?.fecha
    }

}